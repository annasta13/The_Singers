package com.habileducation.thesingers.ui.favourite.favouriteArtist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.habileducation.thesingers.R
import com.habileducation.thesingers.data.domain.model.Artist
import com.habileducation.thesingers.theme.keyLine2
import com.habileducation.thesingers.theme.keyLine3
import com.habileducation.thesingers.ui.components.*

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */

@Composable
fun FavouriteArtistScreen(
    onArtistClicked: (Int) -> Unit,
    viewModel: FavouriteArtistViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()
    val showDialog = remember { mutableStateOf(false) }

    RefreshableScreenContainer(
        loadingState = state.loading,
        onRefresh = viewModel::initState,
    ) {
        when {
            state.error != null -> {
                showDialog.value = true
                state.error?.message?.let { RetryDialog(message = it, isShowDialog = showDialog) }
            }
            else -> {
                FavoriteArtistContentView(
                    data = state.data,
                    onArtistClicked = onArtistClicked
                )
            }
        }
    }
}

@Composable
fun FavoriteArtistContentView(data: List<Artist>, onArtistClicked: (Int) -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        LazyColumn(contentPadding = PaddingValues(keyLine3)) {
            items(data) { item ->
                ArtistItemView(item = item, onArtistClicked = { onArtistClicked(item.id) })
                if (item != data.last()) Spacer(size = 4.dp)
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ArtistItemView(item: Artist, onArtistClicked: () -> Unit) {
    CardView() {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(keyLine2)
                .clickable { onArtistClicked() }
        ) {
            val (titleRef, singerRef, descRef, imageRef) = createRefs()

            Image(
                painter = if (item.image.isEmpty()) painterResource(id = R.drawable.default_image)
                else rememberImagePainter(data = item.image),
                contentDescription = item.names,
                modifier = Modifier
                    .size(60.dp)
                    .constrainAs(imageRef) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                contentScale = ContentScale.Fit
            )
            BodyTextBold(
                text = item.names,
                modifier = Modifier.constrainAs(titleRef) {
                    top.linkTo(parent.top)
                    start.linkTo(imageRef.end, margin = keyLine2)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
                maxLine = 1,
                overflow = TextOverflow.Clip
            )
            BodyText(
                text = "Follower: ${item.followers}",
                modifier = Modifier
                    .constrainAs(singerRef) {
                        top.linkTo(titleRef.bottom)
                        start.linkTo(titleRef.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                maxLine = 1,
                overflow = TextOverflow.Clip
            )
            BodyText(
                text = "Artist ID: ${item.id}",
                modifier = Modifier
                    .constrainAs(descRef) {
                        top.linkTo(singerRef.bottom)
                        start.linkTo(titleRef.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                maxLine = 1,
                overflow = TextOverflow.Clip
            )
        }
    }
}