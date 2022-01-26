package com.habileducation.thesingers.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.habileducation.thesingers.R

/**
 * Created by Annas Surdyanto on 11/01/22.
 *
 */
@Composable
fun DataDescriptor(
    label: String,
    value: String,
    valueWidth: Float = 8f,
    onClick: (() -> Unit)? = null
) {
    val semiColonWidth = 0.2f
    val labelWidth = 10f - valueWidth + semiColonWidth
    Row(modifier = Modifier.clickable { onClick?.let { it() } }) {
        val style = MaterialTheme.typography.body1
        BodyText(
            text = label,
            modifier = Modifier.weight(labelWidth),
            style = style.copy(color = MaterialTheme.colors.secondary)
        )
        BodyText(
            text = ": ",
            modifier = Modifier.weight(semiColonWidth),
            style = style.copy(color = MaterialTheme.colors.secondary)
        )

        val valueStyle = if (onClick != null) style.copy(color = Color.Blue) else style
        BodyTextBold(
            text = value,
            modifier = Modifier
                .weight(valueWidth)
                .padding(bottom = 4.dp),
            style = valueStyle
        )
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun PhotoDescription(label: String, url: String, caption: String = "", valueWidth: Float = 8f) {
    val semiColonWidth = 0.2f
    val labelWidth = 10f - valueWidth + semiColonWidth

    Row {
        val style = MaterialTheme.typography.body2.copy(color = MaterialTheme.colors.secondary)
        BodyText(text = label, modifier = Modifier.weight(labelWidth), style = style)
        BodyText(text = ": ", modifier = Modifier.weight(semiColonWidth), style = style)
        Column(modifier = Modifier.weight(valueWidth)) {
            ClickableImage(
                contentDescription = "image showing",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(100.dp),
                imageUrl = url
            )
            if (caption.isNotEmpty()) CaptionText(text = caption)
        }
    }
}