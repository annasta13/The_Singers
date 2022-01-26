package com.habileducation.thesingers.data.domain.useCase.artistFavourite

import com.habileducation.thesingers.data.domain.model.Artist
import kotlinx.coroutines.flow.Flow

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */
interface GetFavouriteArtist {
    operator fun invoke(): Flow<List<Artist>>
}