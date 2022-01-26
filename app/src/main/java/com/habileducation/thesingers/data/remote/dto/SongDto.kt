package com.habileducation.thesingers.data.remote.dto

import com.habileducation.thesingers.data.domain.model.Song
import com.habileducation.thesingers.data.local.entity.SongFavouriteEntity
import com.squareup.moshi.Json

/**
 * Created by Annas Surdyanto on 23/12/21.
 *
 */
data class SongResult(
    @field:Json(name = "meta") val meta: Status,
    @field:Json(name = "response") val response: SongResponse
)

data class SongResponse(
    @field:Json(name = "song") val songDetail: SongDto
)

data class SongDto(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "artist_names") val artist: String?,
    @field:Json(name = "full_title") val fullTitle: String?,
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "recording_location") val recordingLocation: String?,
    @field:Json(name = "release_date") val releaseDate: String?,
    @field:Json(name = "song_art_image_url") val artThumbnail: String?,
    @field:Json(name = "album") val album: AlbumDto?,
    @field:Json(name = "primary_artist") val primaryArtist: PrimaryArtist?,
)

data class PrimaryArtist(
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "image_url") val image: String?,
)

data class AlbumDto(
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "cover_art_url") val artThumbnail: String?
)

fun SongResult.asSongEntity(): SongFavouriteEntity {
    val song = this.response.songDetail
    return SongFavouriteEntity(
        id = song.id,
        artist = song.artist ?: "",
        fullTitle = song.fullTitle ?: "",
        title = song.title ?: "",
        recordingLocation = song.recordingLocation ?: "",
        releaseDate = song.releaseDate ?: "",
        artThumbnail = song.artThumbnail ?: "",
        album = song.album?.name ?: "",
        artistId = song.primaryArtist?.id ?: 0,
        artistImage = song.primaryArtist?.image ?: "",
        artistName = song.primaryArtist?.name ?: "",
    )
}

fun SongResult.asSong(favourite: Boolean): Song {
    val song = this.response.songDetail
    return Song(
        id = song.id,
        artist = song.artist ?: "",
        fullTitle = song.fullTitle ?: "",
        title = song.title ?: "",
        recordingLocation = song.recordingLocation ?: "",
        releaseDate = song.releaseDate ?: "",
        artThumbnail = song.artThumbnail ?: "",
        album = song.album?.name ?: "",
        artistId = song.primaryArtist?.id ?: 0,
        artistImage = song.primaryArtist?.image ?: "",
        artistName = song.primaryArtist?.name ?: "",
        favourite = favourite
    )
}
