package com.habileducation.thesingers.data.domain.useCase.artistDetail

import com.habileducation.thesingers.data.domain.model.Artist

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */
interface DeleteArtistFavourite {
    suspend operator fun invoke(artist: Artist)
}