package com.habileducation.thesingers.data.remote.dto

import com.habileducation.thesingers.data.domain.model.SongPreview
import com.squareup.moshi.Json

/**
 * Created by Annas Surdyanto on 22/12/21.
 *
 */
data class SearchResult(
    @field:Json(name = "meta") val meta: Status,
    @field:Json(name = "response") val response: SearchResponse
)

data class SearchResponse(
    @field:Json(name = "hits") val hits: List<Hits>
)

data class Hits(
    @field:Json(name = "result") val songPreview: SongPreviewDto
)

data class SongPreviewDto(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "artist_names") val artist: String,
    @field:Json(name = "full_title") val fullTitle: String,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "song_art_image_thumbnail_url") val songArtThumbnail: String,
)

fun SongPreviewDto.asSongPreview(): SongPreview {
    return SongPreview(id, artist, fullTitle, title, songArtThumbnail)
}

fun List<Hits>.asSongPreviewList(): List<SongPreview> {
    return this.map { it.songPreview.asSongPreview() }
}

fun SearchResult.asSongPreviewList(): List<SongPreview> {
    return this.response.hits.asSongPreviewList()
}