package com.habileducation.thesingers.data.domain.useCase.songDetail

import com.habileducation.thesingers.data.domain.model.Song
import com.habileducation.thesingers.data.domain.repository.Repository

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */
class DeleteSongFavouriteImpl(private val repository: Repository) : DeleteSongFavourite {
    override suspend fun invoke(song: Song) {
        return repository.deleteSongFavourite(song)
    }
}