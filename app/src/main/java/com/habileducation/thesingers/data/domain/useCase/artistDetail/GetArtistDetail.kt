package com.habileducation.thesingers.data.domain.useCase.artistDetail

import com.habileducation.thesingers.data.domain.model.Artist
import kotlinx.coroutines.flow.Flow

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */
interface GetArtistDetail {
    operator fun invoke(artistId: Int): Flow<Result<Artist>>
}