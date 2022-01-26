package com.habileducation.thesingers.ui.home

import com.habileducation.thesingers.data.domain.model.SongPreview

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */
data class HomeState(
    val loading: Boolean,
    val data: List<SongPreview>,
    val searchKey: String,
    val error: Throwable?
) {
    companion object {
        val init = HomeState(true, emptyList(), "", null)
    }
}