package com.habileducation.thesingers.data.local.dao

import androidx.room.*
import com.habileducation.thesingers.data.local.entity.ArtistFavouriteEntity

/**
 * Created by Annas Surdyanto on 23/12/21.
 *
 */

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArtist(artistFavourite: ArtistFavouriteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun bulkInsertArtist(artistFavourite: List<ArtistFavouriteEntity>)

    @Delete
    suspend fun deleteArtist(artistFavourite: ArtistFavouriteEntity)

    @Query("SELECT * from artist_favourite WHERE id=:id")
    suspend fun getArtistById(id: Int): ArtistFavouriteEntity?

    @Query("SELECT * from artist_favourite")
    suspend fun getAllArtist(): List<ArtistFavouriteEntity>
}