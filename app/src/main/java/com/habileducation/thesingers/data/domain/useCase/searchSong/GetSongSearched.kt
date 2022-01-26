package com.habileducation.thesingers.data.domain.useCase.searchSong

import com.habileducation.thesingers.data.domain.model.SongPreview
import kotlinx.coroutines.flow.Flow

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */
interface GetSongSearched {
    operator fun invoke(key: String): Flow<Result<List<SongPreview>>>
}