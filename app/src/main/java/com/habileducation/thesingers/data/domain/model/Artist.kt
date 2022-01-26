package com.habileducation.thesingers.data.domain.model

import com.habileducation.thesingers.data.local.entity.ArtistFavouriteEntity

/**
 * Created by Annas Surdyanto on 22/12/21.
 *
 */

data class Artist(
    val id: Int,
    val names: String,
    val facebookName: String,
    val followers: Int,
    val image: String,
    val instagramName: String,
    val isVerified: Boolean,
    val twitterName: String,
    val favourite: Boolean
)

fun Artist.asArtistFavouriteEntity(): ArtistFavouriteEntity {
    return ArtistFavouriteEntity(
        id = id,
        names = names,
        facebookName = facebookName,
        followers = followers,
        image = image,
        instagramName = instagramName,
        isVerified = isVerified,
        twitterName = twitterName
    )
}