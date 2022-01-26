package com.habileducation.thesingers.data.util

import com.habileducation.thesingers.data.local.entity.ArtistFavouriteEntity
import com.habileducation.thesingers.data.local.entity.SongFavouriteEntity
import kotlinx.coroutines.CoroutineScope

/**
 * Created by Annas Surdyanto on 23/12/21.
 *
 */
class TestUtil {

    companion object {
        val mockedArtistEntity = ArtistFavouriteEntity(
            id = 45,
            names = "Marshall Bruce Mathers III",
            facebookName = "Eminem",
            followers = 26197,
            image = "https://images.genius.com/c674178296f3d65792a66f851fbc62fc.900x900x1.png",
            instagramName = "eminem",
            isVerified = true,
            twitterName = "Eminem",
        )

        val mockedSongEntity = SongFavouriteEntity(
            id = 235729,
            artist = "Eminem",
            fullTitle = "Rap God by Eminem",
            title = "Rap God",
            album = "The Marshall Mathers LP2 (Deluxe)",
            releaseDate = "2013-10-14",
            recordingLocation = "Effigy Studios, Ferndale, Michigan",
            artThumbnail = "https://images.genius.com/058e2359838c93395c36119b48a2eff6.300x300x1.png",
            artistId = mockedArtistEntity.id,
            artistImage = mockedArtistEntity.image,
            artistName = mockedArtistEntity.names
        )

        fun CoroutineScope.getResponseBody(name: String): String {
            return this::class.java.classLoader!!.getResourceAsStream(name).bufferedReader()
                .use { it.readText() }
        }
    }


}