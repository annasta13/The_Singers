package com.habileducation.thesingers.data.domain.useCase.songDetail

import com.habileducation.thesingers.data.domain.model.Song
import kotlinx.coroutines.flow.Flow

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */
interface InsertSongFavourite {
    suspend operator fun invoke(song: Song)
}