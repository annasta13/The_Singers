package com.habileducation.thesingers.ui.artistDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habileducation.thesingers.data.domain.model.Artist
import com.habileducation.thesingers.data.domain.model.Song
import com.habileducation.thesingers.data.domain.useCase.artistDetail.ArtistDetailUseCase
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
class ArtistDetailViewModel @Inject constructor(private val useCase: ArtistDetailUseCase) :
    ViewModel() {
    val state = MutableStateFlow(ArtistDetailState.init)

    fun initState(artistId: Int) {
        state.value = state.value.copy(artistId = artistId)
        getArtistDetail()
    }

    fun getArtistDetail() {
        viewModelScope.launch {
            useCase.getArtistDetail.invoke(state.value.artistId)
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
            if (it.favourite) deleteArtistFavourite(it)
            else insertArtistFavourite(it)
        }
    }

    private fun deleteArtistFavourite(artist:Artist) {
        viewModelScope.launch {
            useCase.deleteArtistFavourite.invoke(artist = artist)
            state.value = state.value.copy(data = artist.copy(favourite = false))
        }
    }

    private fun insertArtistFavourite(artist:Artist) {
        viewModelScope.launch {
            useCase.insertArtistFavourite.invoke(artist)
            state.value = state.value.copy(data = artist.copy(favourite = true))
        }
    }
}