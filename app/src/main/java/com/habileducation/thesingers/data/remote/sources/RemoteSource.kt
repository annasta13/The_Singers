package com.habileducation.thesingers.data.remote.sources

import com.habileducation.thesingers.data.remote.dto.ArtistResult
import com.habileducation.thesingers.data.remote.dto.SearchResult
import com.habileducation.thesingers.data.remote.dto.SongResult
import kotlinx.coroutines.flow.Flow

/**
 * Created by Annas Surdyanto on 23/12/21.
 *
 */
interface RemoteSource {

     suspend fun getArtist(id: Int): ArtistResult
     suspend fun getSong(id: Int): SongResult
     suspend fun searchSong(key: String): SearchResult
}