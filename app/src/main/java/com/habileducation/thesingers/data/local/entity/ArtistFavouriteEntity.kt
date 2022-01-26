package com.habileducation.thesingers.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.habileducation.thesingers.data.domain.model.Artist

/**
 * Created by Annas Surdyanto on 22/12/21.
 *
 */
@Entity(tableName = "artist_favourite")
data class ArtistFavouriteEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val names: String,
    @ColumnInfo(name = "facebook_name") val facebookName: String,
    @ColumnInfo(name = "followers_count") val followers: Int,
    @ColumnInfo(name = "image_url") val image: String,
    @ColumnInfo(name = "instagram_name") val instagramName: String,
    @ColumnInfo(name = "is_verified") val isVerified: Boolean,
    @ColumnInfo(name = "twitter_name") val twitterName: String
)

fun ArtistFavouriteEntity.asArtist(): Artist {
    return Artist(
        id = id,
        names = names,
        facebookName = facebookName,
        followers = followers,
        image = image,
        instagramName = instagramName,
        isVerified = isVerified,
        twitterName = twitterName,
        favourite = true
    )
}

fun List<ArtistFavouriteEntity>.asArtistList(): List<Artist> {
    return this.map { it.asArtist() }
}