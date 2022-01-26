package com.habileducation.thesingers.ui.favourite.favouriteArtist

import com.habileducation.thesingers.data.domain.model.Artist

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */
data class FavoriteArtistState(
    val loading: Boolean,
    val data: List<Artist>,
    val error: Throwable?
) {
    companion object {
        val init = FavoriteArtistState(
            loading = true,
            data = emptyList(),
            error = null
        )
    }
}