package com.habileducation.thesingers.ui.favourite.favouriteSong

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habileducation.thesingers.data.domain.useCase.songFavourite.GetFavouriteSong
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
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
class FavouriteSongViewModel @Inject constructor(
    private val getFavouriteSong: GetFavouriteSong,
    private val dispatcher: CoroutineDispatcher
) :
    ViewModel() {
    val state = MutableStateFlow(FavoriteSongState.init)

    init {
        initState()
    }

    fun initState() {
        viewModelScope.launch(dispatcher) {
            getFavouriteSong.invoke()
                .onStart { state.value = state.value.copy(loading = true, error = null) }
                .collect {
                    state.value =
                        state.value.copy(
                            loading = false,
                            data = it
                        )
                }
        }
    }
}