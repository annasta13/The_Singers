package com.habileducation.thesingers.data.domain.useCase.artistDetail

import com.habileducation.thesingers.data.domain.model.Artist
import com.habileducation.thesingers.data.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */
class GetArtistDetailImpl(private val repository: Repository): GetArtistDetail {
    override fun invoke(artistId: Int): Flow<Result<Artist>> {
        return repository.getArtistDetail(artistId)
    }
}