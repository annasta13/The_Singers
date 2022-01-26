package com.habileducation.thesingers.data.local.dao

import androidx.room.*
import com.habileducation.thesingers.data.local.entity.SongFavouriteEntity

/**
 * Created by Annas Surdyanto on 23/12/21.
 *
 */

@Dao
interface SongDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSong(songFavourite: SongFavouriteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun bulkInsertSong(songFavourite: List<SongFavouriteEntity>)

    @Delete
    suspend fun deleteSong(songFavourite: SongFavouriteEntity)

    @Query("SELECT * from song_favourite WHERE id=:id")
    suspend fun getSongById(id: Int): SongFavouriteEntity?

    @Query("SELECT * from song_favourite")
    suspend fun getAllSongs(): List<SongFavouriteEntity>
}