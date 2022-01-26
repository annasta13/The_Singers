package com.habileducation.thesingers.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habileducation.thesingers.R

/**
 * Created by Annas Surdyanto on 13/09/21.
 *
 */

@ExperimentalComposeUiApi
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    label: String,
    state: MutableState<String>? = null,
    focusRequester: FocusRequester? = null,
    inputType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    enabled: Boolean = true,
    icon: Int? = null,
    isInvalid: Boolean = false
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val labelString = label.replace("*", "").lowercase()
    Row(modifier = modifier) {
        TextField(
            value = state?.value ?: "",
            onValueChange = { state?.value = it },
            label = {
                Text(
                    text = label,
                    style = MaterialTheme.typography.caption
                )
            },
            placeholder = {
                Text(
                    text = "Type your $labelString",
                    style = MaterialTheme.typography.caption.copy(
                        colorResource(id = R.color.colorHint)
                    )
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = imeAction,
                keyboardType = inputType
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.surface)
                .align(Alignment.CenterVertically),
            keyboardActions = KeyboardActions(
                onNext = { focusRequester?.requestFocus() },
                onDone = { keyboardController?.hide() }
            ),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
            enabled = enabled,
            trailingIcon = {
                if (isInvalid) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_error),
                        contentDescription = "error"
                    )
                } else {
                    icon?.let {
                        Image(
                            painter = painterResource(id = it), contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        )
    }
}

@ExperimentalComposeUiApi
@Composable
@Preview
fun CustomeTextFieldPreview() {
    CustomTextField(
        modifier = Modifier,
        label = "Test",
        state = rememberSaveable { mutableStateOf("StateTest") },
        focusRequester = null,
        inputType = KeyboardType.Email,
        icon = R.drawable.ic_error
    )
}