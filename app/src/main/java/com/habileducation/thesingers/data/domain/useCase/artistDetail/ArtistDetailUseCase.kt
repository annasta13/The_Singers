package com.habileducation.thesingers.data.domain.useCase.artistDetail

/**
 * Created by Annas Surdyanto on 26/01/22.
 *
 */
data class ArtistDetailUseCase(
    val getArtistDetail: GetArtistDetail,
    val insertArtistFavourite: InsertArtistFavourite,
    val deleteArtistFavourite: DeleteArtistFavourite
)
