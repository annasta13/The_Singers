package com.habileducation.thesingers.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.habileducation.thesingers.data.local.dao.ArtistDao
import com.habileducation.thesingers.data.local.dao.SongDao
import com.habileducation.thesingers.data.local.entity.ArtistFavouriteEntity
import com.habileducation.thesingers.data.local.entity.SongFavouriteEntity


/**
 * Created by Annas Surdyanto on 28/04/21.
 *
 */

@Database(
    entities = [ArtistFavouriteEntity::class, SongFavouriteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun artistDao(): ArtistDao
    abstract fun songDao(): SongDao


    companion object {
        const val databaseName: String = "app_database"
    }
}
