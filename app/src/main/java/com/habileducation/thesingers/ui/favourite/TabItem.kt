package com.habileducation.thesingers.ui.favourite

import androidx.compose.runtime.Composable
import com.habileducation.thesingers.ui.favourite.favouriteArtist.FavouriteArtistScreen
import com.habileducation.thesingers.ui.favourite.favouriteSong.FavouriteSongScreen

/**
 * Created by Annas Surdyanto on 18/11/21.
 *
 */
sealed class TabItem(
    var title: String,
    var screen: @Composable (onSongClicked: (Int) -> Unit, onArtistClicked: (Int) -> Unit) -> Unit
) {
    object FavouriteSong : TabItem(
        "Song",
        { songCLicked, artistClicked -> FavouriteSongScreen(onSongClicked = songCLicked) })

    object FavouriteArtist : TabItem(
        "Artist",
        { songCLicked, artistClicked -> FavouriteArtistScreen(onArtistClicked = artistClicked) })

}