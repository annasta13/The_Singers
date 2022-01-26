package com.habileducation.thesingers.ui.favourite.favouriteSong

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.habileducation.thesingers.R
import com.habileducation.thesingers.data.domain.model.SongPreview
import com.habileducation.thesingers.data.domain.model.asSongSearchedList
import com.habileducation.thesingers.theme.keyLine3
import com.habileducation.thesingers.ui.components.RefreshableScreenContainer
import com.habileducation.thesingers.ui.components.RetryDialog
import com.habileducation.thesingers.ui.components.Spacer
import com.habileducation.thesingers.ui.home.SongItemView

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */

@Composable
fun FavouriteSongScreen(
    onSongClicked: (Int) -> Unit,
    viewModel: FavouriteSongViewModel = hiltViewModel()
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
                FavoriteSongContentView(
                    data = state.data.asSongSearchedList(),
                    onSongClicked = onSongClicked
                )
            }
        }
    }
}

@Composable
fun FavoriteSongContentView(data: List<SongPreview>, onSongClicked: (Int) -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        LazyColumn(contentPadding = PaddingValues(keyLine3)) {
            items(data) { item ->
                SongItemView(item = item, onSongClicked = { onSongClicked(item.id) })
                if (item != data.last()) Spacer(size = 4.dp)
            }
        }
    }
}