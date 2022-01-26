package com.habileducation.thesingers.data.domain.repository


import com.habileducation.thesingers.data.domain.model.Artist
import com.habileducation.thesingers.data.domain.model.Song
import com.habileducation.thesingers.data.domain.model.SongPreview
import kotlinx.coroutines.flow.Flow

/**
 * Created by Annas Surdyanto on 23/12/21.
 *
 */
interface Repository {

    fun getArtistDetail(id: Int): Flow<Result<Artist>>
    fun getSongDetail(id: Int): Flow<Result<Song>>
    fun searchSong(key: String): Flow<Result<List<SongPreview>>>
    fun getAllFavouriteSongs(): Flow<List<Song>>
    fun getAllFavouriteArtists(): Flow<List<Artist>>
    suspend fun insertSongFavourite(song: Song)
    suspend fun deleteSongFavourite(song: Song)
    suspend fun insertArtistFavourite(artist: Artist)
    suspend fun deleteArtistFavourite(artist: Artist)
}