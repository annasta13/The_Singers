package com.habileducation.thesingers.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.habileducation.thesingers.data.domain.model.Song

/**
 * Created by Annas Surdyanto on 22/12/21.
 *
 */
@Entity(tableName = "song_favourite")
data class SongFavouriteEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "artist_names") val artist: String,
    @ColumnInfo(name = "full_title") val fullTitle: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "recording_location") val recordingLocation: String,
    @ColumnInfo(name = "release_date") val releaseDate: String,
    @ColumnInfo(name = "song_art_image_url") val artThumbnail: String,
    @ColumnInfo(name = "album") val album: String,
    @ColumnInfo(name = "artist_id") val artistId: Int,
    @ColumnInfo(name = "artist_image") val artistImage: String,
    @ColumnInfo(name = "artist_name") val artistName: String,
)

fun SongFavouriteEntity.asSong(): Song {
    return Song(
        id = id,
        artist = artist,
        fullTitle = fullTitle,
        title = title,
        recordingLocation = recordingLocation,
        releaseDate = releaseDate,
        artThumbnail = artThumbnail,
        album = album,
        artistId = artistId,
        artistImage = artistImage,
        artistName = artistName,
        favourite = true
    )
}

fun List<SongFavouriteEntity>.asSongList(): List<Song> {
    return this.map { it.asSong() }
}