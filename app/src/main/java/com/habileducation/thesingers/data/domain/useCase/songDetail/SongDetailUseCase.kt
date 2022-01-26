package com.habileducation.thesingers.data.domain.useCase.songDetail

/**
 * Created by Annas Surdyanto on 26/01/22.
 *
 */
data class SongDetailUseCase(
    val getSongDetail: GetSongDetail,
    val insertSongFavourite: InsertSongFavourite,
    val deleteSongFavourite: DeleteSongFavourite
)
