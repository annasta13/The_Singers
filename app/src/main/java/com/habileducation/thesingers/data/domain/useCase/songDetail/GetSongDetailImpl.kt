package com.habileducation.thesingers.data.domain.useCase.songDetail

import com.habileducation.thesingers.data.domain.model.Song
import com.habileducation.thesingers.data.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */
class GetSongDetailImpl(private val repository: Repository): GetSongDetail {
    override fun invoke(songId: Int): Flow<Result<Song>> {
        return repository.getSongDetail(songId)
    }
}