package com.habileducation.thesingers.navGraph

import androidx.navigation.NavController
import androidx.navigation.NavOptions

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */

object AppDestination {
    const val HOME = "HOME"
    const val SONG_DETAIL = "SONG_DETAIL"
    const val ARTIST_DETAIL = "ARTIST_DETAIL"
    const val FAVOURITE = "FAVOURITE"
}

object ScreenArgument {
    const val SONG_ID = "songId"
    const val ARTIST_ID = "artistId"
}

class AppAction(navController: NavController) {
    private val inclusiveNavOptions = NavOptions.Builder()
        .setPopUpTo(destinationId = 0, inclusive = true, saveState = true)
        .build()

    val navigateToSongDetail: (Int) -> Unit = {
        navController.navigate(
            route = "${AppDestination.SONG_DETAIL}/$it"
        )
    }

    val navigateToArtistDetail: (Int) -> Unit = {
        navController.navigate(
            route = "${AppDestination.ARTIST_DETAIL}/$it"
        )
    }
    val navigateToFavourite: () -> Unit = {
        navController.navigate(
            route = AppDestination.FAVOURITE
        )
    }
}