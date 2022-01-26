package com.habileducation.thesingers.data.domain.repository

import com.habileducation.thesingers.data.domain.model.*
import com.habileducation.thesingers.data.local.entity.asSongList
import com.habileducation.thesingers.data.local.sources.LocalSource
import com.habileducation.thesingers.data.remote.dto.asArtist
import com.habileducation.thesingers.data.remote.dto.asSong
import com.habileducation.thesingers.data.remote.dto.asSongPreviewList
import com.habileducation.thesingers.data.remote.sources.RemoteSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

/**
 * Created by Annas Surdyanto on 23/12/21.
 *
 */
class RepositoryImpl(private val localSource: LocalSource, private val remoteSource: RemoteSource) :
    Repository {
    override fun getArtistDetail(id: Int): Flow<Result<Artist>> = flow {
        val localArtist = localSource.getArtistById(id)
        val result = remoteSource.getArtist(id)
        emit(Result.success(result.asArtist(localArtist != null)))
    }.catch { e -> emit(Result.failure(e)) }

    override fun getSongDetail(id: Int): Flow<Result<Song>> = flow {
        val localSong = localSource.getSongById(id)
        val result = remoteSource.getSong(id)
        emit(Result.success(result.asSong(localSong != null)))
    }.catch { e -> emit(Result.failure(e)) }

    override fun searchSong(key: String): Flow<Result<List<SongPreview>>> = flow {
        val result = remoteSource.searchSong(key)
        emit(Result.success(result.asSongPreviewList()))
    }.catch { e -> emit(Result.failure(e)) }

    override fun getAllFavouriteSongs(): Flow<List<Song>> = flow {
        emit(localSource.getAllFavouriteSongs().asSongList())
    }

    override fun getAllFavouriteArtists(): Flow<List<Artist>> = flow {
        emit(localSource.getAllFavouriteArtists())
    }

    override suspend fun insertSongFavourite(song: Song) {
        localSource.insertSong(song.asSongFavouriteEntity())
    }

    override suspend fun deleteSongFavourite(song: Song) {
        localSource.deleteSong(song.asSongFavouriteEntity())
    }

    override suspend fun insertArtistFavourite(artist: Artist) {
        localSource.insertArtist(artist.asArtistFavouriteEntity())
    }

    override suspend fun deleteArtistFavourite(artist: Artist) {
        localSource.deleteArtist(artist.asArtistFavouriteEntity())
    }
}