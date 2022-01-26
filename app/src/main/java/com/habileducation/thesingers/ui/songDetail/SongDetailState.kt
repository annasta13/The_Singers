package com.habileducation.thesingers.ui.songDetail

import com.habileducation.thesingers.data.domain.model.Song

/**
 * Created by Annas Surdyanto on 22/01/22.
 *
 */
data class SongDetailState(
    val isLoading: Boolean,
    val songId: Int,
    val data: Song?,
    val error: Throwable?
) {
    companion object {
        val init = SongDetailState(false, 0, null,  null)
    }
}
