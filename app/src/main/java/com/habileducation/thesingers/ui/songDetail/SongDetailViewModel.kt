package com.habileducation.thesingers.ui.songDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habileducation.thesingers.data.domain.model.Song
import com.habileducation.thesingers.data.domain.useCase.songDetail.SongDetailUseCase
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
class SongDetailViewModel @Inject constructor(private val useCase: SongDetailUseCase) :
    ViewModel() {
    val state = MutableStateFlow(SongDetailState.init)

    fun initState(songId: Int) {
        state.value = state.value.copy(songId = songId)
        getSongDetail()
    }

    fun getSongDetail() {
        viewModelScope.launch {
            useCase.getSongDetail.invoke(state.value.songId)
                .onStart { state.value = state.value.copy(isLoading = true, error = null) }
                .collect {
                    state.value =
                        state.value.copy(
                            isLoading = false,
                            data = it.getOrNull(),
                            error = it.exceptionOrNull()
                        )
                }
        }
    }

    fun setFavourite() {
        state.value.data?.let {
            if (it.favourite) deleteSongFavorite(it)
            else insertSongFavorite(it)
        }
    }

    private fun deleteSongFavorite(song: Song) {
        viewModelScope.launch {
            useCase.deleteSongFavourite.invoke(song = song)
            state.value = state.value.copy(data = song.copy(favourite = false))
        }
    }

    private fun insertSongFavorite(song: Song) {
        viewModelScope.launch {
            useCase.insertSongFavourite.invoke(song)
            state.value = state.value.copy(data = song.copy(favourite = true))
        }
    }
}