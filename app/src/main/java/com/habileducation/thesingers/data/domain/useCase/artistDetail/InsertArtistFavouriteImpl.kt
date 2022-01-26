package com.habileducation.thesingers.data.domain.useCase.artistDetail

import com.habileducation.thesingers.data.domain.model.Artist
import com.habileducation.thesingers.data.domain.repository.Repository

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */
class InsertArtistFavouriteImpl(private val repository: Repository) : InsertArtistFavourite {
    override suspend fun invoke(artist: Artist) {
        return repository.insertArtistFavourite(artist)
    }
}