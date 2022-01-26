package com.habileducation.thesingers.ui.home

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
import coil.annotation.ExperimentalCoilApi
import com.habileducation.thesingers.R
import com.habileducation.thesingers.data.domain.model.SongPreview
import com.habileducation.thesingers.theme.keyLine3
import com.habileducation.thesingers.ui.components.RefreshableScreenContainer
import com.habileducation.thesingers.ui.components.RetryDialog
import com.habileducation.thesingers.ui.components.SearchView
import com.habileducation.thesingers.ui.components.Spacer

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */

@Composable
fun HomeScreen(
    onSongClicked: (Int) -> Unit,
    onNavigateToFavourite: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()
    val showDialog = remember { mutableStateOf(false) }

    RefreshableScreenContainer(
        barTitle = stringResource(id = R.string.app_name),
        loadingState = state.loading,
        onRefresh = viewModel::initState,
        trailingIcon = R.drawable.favorited,
        onTrailingIconClicked = onNavigateToFavourite
    ) {
        when {
            state.error != null -> {
                showDialog.value = true
                state.error?.message?.let { RetryDialog(message = it, isShowDialog = showDialog) }
            }
            else -> {
                HomeContentScreen(
                    data = state.data,
                    state.searchKey,
                    onSearched = viewModel::searchSong,
                    onSongClicked = onSongClicked
                )
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
internal fun HomeContentScreen(
    data: List<SongPreview>,
    searchKey: String,
    onSearched: (String) -> Unit,
    onSongClicked: (Int) -> Unit
) {
    val searchKey = remember { mutableStateOf(searchKey) }
    Scaffold(modifier = Modifier.fillMaxSize()) {
        LazyColumn(contentPadding = PaddingValues(keyLine3)) {
            item {
                SearchView(
                    state = searchKey,
                    label = stringResource(R.string.search_singer_song),
                    onSearched = onSearched
                )
                Spacer()
            }
            items(data) { item ->
                SongItemView(item = item, onSongClicked = { onSongClicked(item.id) })
                if (item != data.last()) Spacer(size = 4.dp)
            }
        }
    }
}