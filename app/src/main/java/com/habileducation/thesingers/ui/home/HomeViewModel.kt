package com.habileducation.thesingers.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habileducation.thesingers.data.domain.useCase.searchSong.GetSongSearched
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */

@HiltViewModel
class HomeViewModel @Inject constructor(private val getSongSearched: GetSongSearched) :
    ViewModel() {
    val state = MutableStateFlow(HomeState.init)

    init {
        initState()
    }

    fun initState() {
        viewModelScope.launch {
            val key = if (state.value.searchKey.isEmpty()) "Eminem" else state.value.searchKey
            getSongSearched.invoke(key)
                .onStart { state.value = state.value.copy(loading = true, error = null) }
                .collect {
                    state.value =
                        state.value.copy(
                            loading = false,
                            data = it.getOrNull() ?: emptyList(),
                            error = it.exceptionOrNull()
                        )
                }
        }
    }

    fun searchSong(key: String) {
        state.value = state.value.copy(searchKey = key)
        initState()
    }
}