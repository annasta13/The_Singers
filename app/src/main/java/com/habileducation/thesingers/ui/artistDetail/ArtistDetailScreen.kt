package com.habileducation.thesingers.ui.artistDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.habileducation.thesingers.R
import com.habileducation.thesingers.data.domain.model.Artist
import com.habileducation.thesingers.theme.keyLine3
import com.habileducation.thesingers.ui.components.*

/**
 * Created by Annas Surdyanto on 22/01/22.
 *
 */

@Composable
fun ArtistDetailScreen(
    artistId: Int,
    viewModel: ArtistDetailViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val defaultBarTitle = stringResource(id = R.string.app_name)
    val barTitle = remember { mutableStateOf(defaultBarTitle) }
    val showDialog = remember { mutableStateOf(false) }
    val initState = { viewModel.initState(artistId) }

    LaunchedEffect(artistId) {
        if (state == ArtistDetailState.init) initState()
    }
    val trailingIcon =
        if (state.data?.favourite == true) R.drawable.favorited
        else R.drawable.unfavorited
    RefreshableScreenContainer(
        barTitle = barTitle.value,
        loadingState = state.isLoading,
        onRefresh = viewModel::getArtistDetail,
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
                    barTitle.value = it.names
                    ArtistDetailContentView(artist = it)
                }
            }
        }
    }
}

@Composable
fun ArtistDetailContentView(artist: Artist) {
    Scaffold(
        modifier = Modifier
            .padding(keyLine3)
            .verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer()
            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterHorizontally)
            ) {
                ClickableImage(
                    contentDescription = "artist_image",
                    modifier = Modifier
                        .size(300.dp)
                        .fillMaxWidth(),
                    imageUrl = artist.image
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_verified),
                    contentDescription = "verified_icon",
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.TopEnd),
                    colorFilter = ColorFilter.tint(color = Color.Yellow)
                )
            }
            Spacer()
            val width = 6f
            DataDescriptor(
                label = "Facebook",
                value = artist.facebookName,
                valueWidth = width
            )
            DataDescriptor(
                label = "Followers", value = artist.followers.toString(),
                valueWidth = width
            )
            if (artist.instagramName.isNotEmpty()) DataDescriptor(
                label = "Instagram",
                value = artist.instagramName,
                valueWidth = width
            )
            if (artist.twitterName.isNotEmpty()) DataDescriptor(
                label = "Twitter",
                value = artist.twitterName,
                valueWidth = width
            )
        }
    }
}