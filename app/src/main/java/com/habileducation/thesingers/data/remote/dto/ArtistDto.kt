package com.habileducation.thesingers.data.remote.dto

import com.habileducation.thesingers.data.domain.model.Artist
import com.habileducation.thesingers.data.local.entity.ArtistFavouriteEntity
import com.squareup.moshi.Json

/**
 * Created by Annas Surdyanto on 22/12/21.
 *
 */
data class ArtistResult(
    @field:Json(name = "meta") val meta: Status,
    @field:Json(name = "response") val response: ArtistResponse
)

fun ArtistResult.asArtistEntity(): ArtistFavouriteEntity {
    val artist = response.artistDto
    return ArtistFavouriteEntity(
        id = artist.id,
        names = artist.names?.get(0) ?: "",
        facebookName = artist.facebookName ?: "",
        followers = artist.followers ?: 0,
        image = artist.image ?: "",
        instagramName = artist.instagramName ?: "",
        isVerified = artist.isVerified ?: false,
        twitterName = artist.twitterName ?: "",
    )
}

fun ArtistResult.asArtist(favourite: Boolean): Artist {
    val artist = response.artistDto
    return Artist(
        id = artist.id,
        names = if (!artist.names.isNullOrEmpty()) artist.names.get(0) else "",
        facebookName = artist.facebookName ?: "",
        followers = artist.followers ?: 0,
        image = artist.image ?: "",
        instagramName = artist.instagramName ?: "",
        isVerified = artist.isVerified ?: false,
        twitterName = artist.twitterName ?: "",
        favourite = favourite
    )
}

data class ArtistResponse(
    @field:Json(name = "artist") val artistDto: ArtistDto
)

data class ArtistDto(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "alternate_names") val names: List<String>?,
    @field:Json(name = "facebook_name") val facebookName: String?,
    @field:Json(name = "followers_count") val followers: Int?,
    @field:Json(name = "image_url") val image: String?,
    @field:Json(name = "instagram_name") val instagramName: String?,
    @field:Json(name = "is_verified") val isVerified: Boolean?,
    @field:Json(name = "twitter_name") val twitterName: String?
)