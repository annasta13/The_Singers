package com.habileducation.thesingers.ui.artistDetail

import com.habileducation.thesingers.data.domain.model.Artist

/**
 * Created by Annas Surdyanto on 22/01/22.
 *
 */
data class ArtistDetailState(
    val isLoading: Boolean,
    val artistId: Int,
    val data: Artist?,
    val error: Throwable?
) {
    companion object {
        val init = ArtistDetailState(false, 0, null, null)
    }
}
