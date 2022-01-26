package com.habileducation.thesingers.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.habileducation.thesingers.theme.keyLine12

/**
 * Created by Annas Surdyanto on 06/01/22.
 *
 */

@Composable
fun CardView(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            //.border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
            .background(MaterialTheme.colors.surface),
        elevation = 3.dp,
        content = content
    )
}

@Composable
fun BorderedCardView(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
            .background(MaterialTheme.colors.surface),
        elevation = 10.dp,
        content = content
    )
}