package com.habileducation.thesingers.data.domain.useCase.songFavourite

import com.habileducation.thesingers.data.domain.model.Song
import com.habileducation.thesingers.data.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */
class GetFavouriteSongImpl(private val repository: Repository) : GetFavouriteSong {
    override fun invoke(): Flow<List<Song>> {
        return repository.getAllFavouriteSongs()
    }
}