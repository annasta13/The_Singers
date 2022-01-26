package com.habileducation.thesingers.navGraph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.habileducation.thesingers.ui.artistDetail.ArtistDetailScreen
import com.habileducation.thesingers.ui.favourite.FavouriteScreen
import com.habileducation.thesingers.ui.home.HomeScreen
import com.habileducation.thesingers.ui.songDetail.SongDetailScreen

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */

@Composable
fun NavGraph() {
    val navController: NavHostController = rememberNavController()
    val action = remember(navController) { AppAction(navController) }

    NavHost(navController = navController, startDestination = AppDestination.HOME) {
        composable(route = AppDestination.HOME) {
            HomeScreen(
                onSongClicked = action.navigateToSongDetail,
                onNavigateToFavourite = action.navigateToFavourite
            )
        }

        composable(
            route = "${AppDestination.SONG_DETAIL}/{${ScreenArgument.SONG_ID}}",
            arguments = listOf(
                navArgument(ScreenArgument.SONG_ID) { type = NavType.IntType },
            )
        ) { entry ->
            val songId = entry.arguments?.getInt(ScreenArgument.SONG_ID) ?: 0
            SongDetailScreen(songId, onArtistCLicked = action.navigateToArtistDetail)
        }

        composable(
            route = "${AppDestination.ARTIST_DETAIL}/{${ScreenArgument.ARTIST_ID}}",
            arguments = listOf(
                navArgument(ScreenArgument.ARTIST_ID) { type = NavType.IntType },
            )
        ) { entry ->
            val artistId = entry.arguments?.getInt(ScreenArgument.ARTIST_ID) ?: 0
            ArtistDetailScreen(artistId)
        }
        composable(route = AppDestination.FAVOURITE) {
            FavouriteScreen(
                onSongClicked = action.navigateToSongDetail,
                onArtistClicked = action.navigateToArtistDetail
            )
        }
    }
}