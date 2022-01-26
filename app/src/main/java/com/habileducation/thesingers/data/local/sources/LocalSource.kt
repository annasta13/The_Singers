package com.habileducation.thesingers.data.local.sources

import com.habileducation.thesingers.data.domain.model.Artist
import com.habileducation.thesingers.data.local.entity.ArtistFavouriteEntity
import com.habileducation.thesingers.data.local.entity.SongFavouriteEntity

/**
 * Created by Annas Surdyanto on 23/12/21.
 *
 */
interface LocalSource {
    suspend fun insertArtist(artistFavourite: ArtistFavouriteEntity)
    suspend fun getArtistById(id: Int): ArtistFavouriteEntity?
    suspend fun deleteArtist(artistFavourite: ArtistFavouriteEntity)

    suspend fun insertSong(songFavourite: SongFavouriteEntity)
    suspend fun getSongById(id: Int): SongFavouriteEntity?
    suspend fun deleteSong(songFavourite: SongFavouriteEntity)
    suspend fun getAllFavouriteSongs(): List<SongFavouriteEntity>
    suspend fun getAllFavouriteArtists(): List<Artist>
}