package com.habileducation.thesingers.ui.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.habileducation.thesingers.R

/**
 * Created by Annas Surdyanto on 31/08/21.
 *
 */

@Composable
fun DialogScreen(
    title: String,
    message: String,
    positiveText: String = "Ok",
    negativeText: String = "Cancel",
    onConfirmed: (() -> Unit?)? = null,
    onCancel: (() -> Unit?)? = null,
    isShowDialog: MutableState<Boolean>
) {
    if (isShowDialog.value) {
        AlertDialog(
            onDismissRequest = { },
            title = { Text(text = title) },
            text = { Text(text = message) },
            confirmButton = {
                PrimaryButton(
                    text = positiveText,
                    onClick = { onConfirmed?.let { it() } }
                )
            },
            dismissButton =
            {
                SecondaryButton(onClick = {
                    isShowDialog.value = false
                    onCancel?.let { it() }
                }, text = negativeText)
            }
        )
    }
}

@Composable
fun RetryDialog(
    message: String,
    onConfirmed: (() -> Unit?)? = null,
    onCancel: (() -> Unit?)? = null,
    isShowDialog: MutableState<Boolean>
) {
    DialogScreen(
        title = stringResource(R.string.error_title),
        message = message,
        positiveText = stringResource(R.string.retry),
        negativeText = stringResource(R.string.cancel),
        onConfirmed = onConfirmed,
        isShowDialog = isShowDialog,
        onCancel = onCancel
    )
}

@Composable
fun OkayErrorDialog(
    message: String,
    isShowDialog: MutableState<Boolean>,
    positiveText: String = "Ok",
    onConfirmed: (() -> Unit?)? = null
) {
    if (isShowDialog.value) {
        AlertDialog(
            onDismissRequest = { },
            title = { Text(text = stringResource(R.string.error_title)) },
            text = { Text(text = message) },
            confirmButton = {
                PrimaryButton(
                    text = positiveText,
                    onClick = {
                        onConfirmed?.let { it() }
                        isShowDialog.value = false
                    }
                )
            }
        )
    }
}

@Composable
fun OkaySuccessDialog(
    message: String,
    isShowDialog: MutableState<Boolean>,
    onConfirmed: (() -> Unit?)? = null
) {
    if (isShowDialog.value) {
        AlertDialog(
            onDismissRequest = { },
            title = { Text(text = "Great") },
            text = { Text(text = message) },
            confirmButton = {
                PrimaryButton(
                    text = "Ok",
                    onClick = {
                        onConfirmed?.let { it() }
                        isShowDialog.value = false
                    }
                )
            }
        )
    }
}

@Composable
@Preview
fun DialogScreenPreview() {
    DialogScreen(
        title = "Error",
        message = "Something went wrong. Retry?",
        positiveText = "Yes",
        negativeText = "No",
        onConfirmed = { },
        onCancel = {},
        remember { mutableStateOf(false) }
    )
}