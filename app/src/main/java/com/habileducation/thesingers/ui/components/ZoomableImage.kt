package com.habileducation.thesingers.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.habileducation.thesingers.R
import com.habileducation.thesingers.theme.keyLine3
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ClickableImage(
    modifier: Modifier = Modifier,
    imageUrl: String = "",
    title: String? = null,
    description: String? = null,
    contentScale: ContentScale = ContentScale.FillBounds,
    contentDescription: String? = null
) {
    val showImage = remember { mutableStateOf(false) }
    val painter =
        if (imageUrl.isEmpty()) painterResource(id = R.drawable.default_image)
        else rememberImagePainter(imageUrl)
    Image(
        painter = painter,
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier.clickable { showImage.value = true }
    )

    if (showImage.value && imageUrl.isNotEmpty()) ZoomableImage(
        image = imageUrl,
        isShowing = showImage,
        description = description,
        title = title
    )
}

@Composable
fun ZoomableImage(
    image: Any,
    title: String? = null,
    description: String? = null,
    isShowing: MutableState<Boolean>
) {
    var scale by remember { mutableStateOf(1f) }
    var rotation by remember { mutableStateOf(0f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    val state = rememberTransformableState { zoomChange, offsetChange, rotationChange ->
        scale *= zoomChange
        rotation += rotationChange
        offset += offsetChange
    }

    if (isShowing.value) {
        Dialog(
            onDismissRequest = { isShowing.value = false },
            content = {
                Box(modifier = Modifier.padding()) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .background(
                                MaterialTheme.colors.surface,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .fillMaxWidth()
                            .padding(
                                keyLine3
                            )
                            .verticalScroll(rememberScrollState())
                    ) {
                        title?.let {
                            BodyTextBold(
                                text = it,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                            Spacer()
                        }
                        GlideImage(
                            imageModel = image,
                            modifier = Modifier
                                .size(300.dp)
                                .transformable(state = state)
                                .graphicsLayer(
                                    scaleX = scale,
                                    scaleY = scale,
                                    rotationZ = rotation,
                                    translationX = offset.x,
                                    translationY = offset.y
                                ),
                            contentScale = ContentScale.Fit,
                            contentDescription = null
                        )
                        description?.let {
                            BodyText(
                                text = it,
                                modifier = Modifier.fillMaxWidth(),
                                style = MaterialTheme.typography.caption.copy(Color.DarkGray),
                                textAlign = TextAlign.Justify
                            )
                        }
                        Spacer()
                        PrimaryButton(text = "Dismiss", onClick = {
                            isShowing.value = false
                        })
                    }
                }
            })
    }
}