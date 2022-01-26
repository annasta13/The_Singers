package com.habileducation.thesingers.data.local.sources

import com.habileducation.thesingers.data.domain.model.Artist
import com.habileducation.thesingers.data.local.dao.ArtistDao
import com.habileducation.thesingers.data.local.dao.SongDao
import com.habileducation.thesingers.data.local.entity.ArtistFavouriteEntity
import com.habileducation.thesingers.data.local.entity.SongFavouriteEntity
import com.habileducation.thesingers.data.local.entity.asArtistList

/**
 * Created by Annas Surdyanto on 23/12/21.
 *
 */
class LocalSourceImpl(private val artistDao: ArtistDao, private val songDao: SongDao) :
    LocalSource {
    override suspend fun insertArtist(artistFavourite: ArtistFavouriteEntity) {
        artistDao.insertArtist(artistFavourite)
    }

    override suspend fun getArtistById(id: Int): ArtistFavouriteEntity? {
        return artistDao.getArtistById(id)
    }

    override suspend fun deleteArtist(artistFavourite: ArtistFavouriteEntity) {
        artistDao.deleteArtist(artistFavourite)
    }

    override suspend fun insertSong(songFavourite: SongFavouriteEntity) {
        songDao.insertSong(songFavourite)
    }

    override suspend fun getSongById(id: Int): SongFavouriteEntity? {
        return songDao.getSongById(id)
    }

    override suspend fun deleteSong(songFavourite: SongFavouriteEntity) {
        songDao.insertSong(songFavourite)
    }

    override suspend fun getAllFavouriteSongs(): List<SongFavouriteEntity> {
        return songDao.getAllSongs()
    }

    override suspend fun getAllFavouriteArtists(): List<Artist> {
        return artistDao.getAllArtist().asArtistList()
    }
}