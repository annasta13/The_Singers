package com.habileducation.thesingers.data.domain.useCase.artistDetail

import com.habileducation.thesingers.data.domain.model.Artist
import com.habileducation.thesingers.data.domain.repository.Repository

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */
class DeleteArtistFavouriteImpl(private val repository: Repository) : DeleteArtistFavourite {
    override suspend fun invoke(artist: Artist) {
        return repository.deleteArtistFavourite(artist)
    }
}