package com.habileducation.thesingers.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.habileducation.thesingers.R
import com.habileducation.thesingers.data.domain.model.SongPreview
import com.habileducation.thesingers.theme.keyLine2
import com.habileducation.thesingers.ui.components.BodyText
import com.habileducation.thesingers.ui.components.BodyTextBold
import com.habileducation.thesingers.ui.components.CardView

/**
 * Created by Annas Surdyanto on 23/01/22.
 *
 */

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SongItemView(item: SongPreview, onSongClicked: () -> Unit) {
    CardView() {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(keyLine2)
                .clickable { onSongClicked() }
        ) {
            val (titleRef, singerRef, descRef, imageRef) = createRefs()

            Image(
                painter = if (item.songArtThumbnail.isEmpty()) painterResource(id = R.drawable.default_image)
                else rememberImagePainter(data = item.songArtThumbnail),
                contentDescription = item.fullTitle,
                modifier = Modifier
                    .size(60.dp)
                    .constrainAs(imageRef) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                contentScale = ContentScale.Fit
            )
            BodyTextBold(
                text = "Title: ${item.title}",
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
                text = "Singer: ${item.artist}",
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
                text = "Full title: ${item.fullTitle}",
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