package com.habileducation.thesingers.data.domain.useCase.songFavourite

import com.habileducation.thesingers.data.domain.model.Song
import kotlinx.coroutines.flow.Flow

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */
interface GetFavouriteSong {
    operator fun invoke(): Flow<List<Song>>
}