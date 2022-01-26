package com.habileducation.thesingers.data.domain.useCase.searchSong

import com.habileducation.thesingers.data.domain.model.SongPreview
import com.habileducation.thesingers.data.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */
class GetSongSearchedImpl(private val repository: Repository) : GetSongSearched {
    override fun invoke(key: String): Flow<Result<List<SongPreview>>> {
        return repository.searchSong(key)
    }
}