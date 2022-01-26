package com.habileducation.thesingers.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

/**
 * Created by Annas Surdyanto on 09/12/21.
 *
 */

@Composable
fun BodyTextBold(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    style: TextStyle = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.SemiBold),
    overflow: TextOverflow = TextOverflow.Clip,
    maxLine: Int = 10000
) {
    Text(
        text = text,
        style = style,
        modifier = modifier,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLine
    )
}

@Composable
fun BodyText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    style: TextStyle = MaterialTheme.typography.body1,
    overflow: TextOverflow = TextOverflow.Visible,
    maxLine: Int = 10000
) {
    Text(
        text = text,
        style = style,
        modifier = modifier,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLine
    )
}

@Composable
fun CaptionTextBlack(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.caption.copy(color = MaterialTheme.colors.onPrimary),
    overflow: TextOverflow = TextOverflow.Clip,
    maxLine: Int = 10000
) {
    Text(
        text = text,
        style = style,
        modifier = modifier,
        overflow = overflow,
        maxLines = maxLine
    )
}

@Composable
fun CaptionText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.caption,
    textAlign: TextAlign = TextAlign.Start,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLine: Int = 10000
) {
    Text(
        text = text,
        style = style,
        modifier = modifier,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLine
    )
}

@Composable
fun BodyTextSecondary(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.secondary),
    overflow: TextOverflow = TextOverflow.Clip,
    maxLine: Int = 10000
) {
    Text(
        text = text,
        modifier = modifier,
        style = style,
        overflow = overflow,
        maxLines = maxLine
    )
}