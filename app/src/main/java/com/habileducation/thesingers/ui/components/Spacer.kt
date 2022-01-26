package com.habileducation.thesingers.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.habileducation.thesingers.theme.keyLine2

/**
 * Created by Annas Surdyanto on 16/08/21.
 *
 */
@Composable
fun Spacer(
    modifier: Modifier = Modifier,
    size: Dp = keyLine2
) {
    Spacer(modifier = modifier.padding(size))
}