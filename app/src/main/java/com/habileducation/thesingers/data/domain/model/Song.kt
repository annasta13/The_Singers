package com.habileducation.thesingers.data.domain.model

import com.habileducation.thesingers.data.local.entity.SongFavouriteEntity

/**
 * Created by Annas Surdyanto on 22/12/21.
 *
 */

data class Song(
    val id: Int,
    val artist: String,
    val fullTitle: String,
    val title: String,
    val recordingLocation: String,
    val releaseDate: String,
    val artThumbnail: String,
    val album: String,
    val artistId: Int,
    val artistImage: String,
    val artistName: String,
    val favourite: Boolean
)

fun Song.asSongSearched(): SongPreview {
    return SongPreview(id, artistName, fullTitle, title, artThumbnail)
}

fun Song.asSongFavouriteEntity(): SongFavouriteEntity {
    return SongFavouriteEntity(
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
        artistName = artistName
    )
}

fun List<Song>.asSongSearchedList(): List<SongPreview> {
    return this.map { it.asSongSearched() }
}