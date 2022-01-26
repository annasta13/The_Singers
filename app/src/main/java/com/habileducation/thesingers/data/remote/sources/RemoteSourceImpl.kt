package com.habileducation.thesingers.data.remote.sources

import com.habileducation.thesingers.data.remote.ApiService
import com.habileducation.thesingers.data.remote.dto.ArtistResult
import com.habileducation.thesingers.data.remote.dto.SearchResult
import com.habileducation.thesingers.data.remote.dto.SongResult

/**
 * Created by Annas Surdyanto on 23/12/21.
 *
 */
class RemoteSourceImpl(private val apiService: ApiService) : RemoteSource {
    override suspend fun getArtist(id: Int): ArtistResult {
        return apiService.getArtistDetail(id)
    }

    override suspend fun getSong(id: Int): SongResult {
        return apiService.getSongDetail(id)
    }

    override suspend fun searchSong(key: String): SearchResult {
        return apiService.getSongSearched(key)
    }
}