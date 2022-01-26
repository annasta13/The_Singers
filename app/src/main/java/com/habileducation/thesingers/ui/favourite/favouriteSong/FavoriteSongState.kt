package com.habileducation.thesingers.ui.favourite.favouriteSong

import com.habileducation.thesingers.data.domain.model.Song

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */
data class FavoriteSongState(
    val loading: Boolean,
    val data: List<Song>,
    val error: Throwable?
) {
    companion object {
        val init = FavoriteSongState(
            loading = true,
            data = emptyList(),
            error = null
        )
    }
}