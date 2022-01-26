package com.habileducation.thesingers.ui.songDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.habileducation.thesingers.R
import com.habileducation.thesingers.data.domain.model.Song
import com.habileducation.thesingers.theme.keyLine3
import com.habileducation.thesingers.ui.components.*

/**
 * Created by Annas Surdyanto on 22/01/22.
 *
 */

@Composable
fun SongDetailScreen(
    songId: Int,
    onArtistCLicked: (Int) -> Unit,
    viewModel: SongDetailViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val defaultBarTitle = stringResource(id = R.string.app_name)
    val barTitle = remember { mutableStateOf(defaultBarTitle) }
    val showDialog = remember { mutableStateOf(false) }
    val initState = { viewModel.initState(songId) }

    LaunchedEffect(songId) {
        if (state == SongDetailState.init) initState()
    }
    val trailingIcon =
        if (state.data?.favourite == true) R.drawable.favorited
        else R.drawable.unfavorited
    RefreshableScreenContainer(
        barTitle = barTitle.value,
        loadingState = state.isLoading,
        onRefresh = viewModel::getSongDetail,
        trailingIcon = trailingIcon,
        onTrailingIconClicked = viewModel::setFavourite
    ) {
        when {
            state.error != null -> {
                showDialog.value = true
                state.error?.message?.let {
                    RetryDialog(
                        message = it,
                        isShowDialog = showDialog,
                        onConfirmed = initState
                    )
                }
            }
            else -> {
                state.data?.let {
                    barTitle.value = it.title
                    SongDetailContentView(
                        song = it,
                        onArtistCLicked = onArtistCLicked
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SongDetailContentView(song: Song, onArtistCLicked: (Int) -> Unit) {
    Scaffold(
        modifier = Modifier
            .padding(keyLine3)
            .verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer()
            ClickableImage(
                contentDescription = "song_image",
                modifier = Modifier
                    .size(300.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                imageUrl = song.artThumbnail
            )
            Spacer()
            val width = 6f
            DataDescriptor(
                label = "Artist",
                value = song.artist,
                onClick = { onArtistCLicked(song.artistId) },
                valueWidth = width
            )
            DataDescriptor(
                label = "Album", value = song.album,
                valueWidth = width
            )
            if (song.releaseDate.isNotEmpty()) DataDescriptor(
                label = "Release Date",
                value = song.releaseDate,
                valueWidth = width
            )
            if (song.recordingLocation.isNotEmpty()) DataDescriptor(
                label = "Recording Location",
                value = song.recordingLocation,
                valueWidth = width
            )
        }
    }
}