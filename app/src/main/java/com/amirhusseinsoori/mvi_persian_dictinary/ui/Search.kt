package com.amirhusseinsoori.mvi_persian_dictinary.ui

/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.content.res.Configuration
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amirhusseinsoori.mvi_persian_dictinary.R
import com.amirhusseinsoori.mvi_persian_dictinary.common.clearFocusOnKeyboardDismiss
import com.amirhusseinsoori.mvi_persian_dictinary.common.mirroringCancelIcon
import com.amirhusseinsoori.mvi_persian_dictinary.ui.component.DicSurface
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.DicTheme


@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
 fun SearchBar(
    query: String ,
    onQueryChange: (String) -> Unit,

    onClearQuery: () -> Unit,
    onSearchFocusChange: (Boolean) -> Unit,
    enableClose:Boolean,
    modifier: Modifier = Modifier
) {
    var kbClosed: () -> Unit = {}
    val focusManager = LocalFocusManager.current

    var ctx= LocalContext.current
    DicSurface(
        color = DicTheme.colors.uiFloated,
        contentColor = DicTheme.colors.textSecondary,
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        Box(Modifier.fillMaxSize()) {
            if (query.isEmpty()) {
                SearchHint()
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight()
            ) {

                    AnimatedVisibility(visible = enableClose) {
                        IconButton(onClick = onClearQuery) {
                            Icon(
                                imageVector = mirroringCancelIcon(),
                                tint = DicTheme.colors.iconPrimary,
                                contentDescription = stringResource(R.string.label_back)
                            )
                        }
                    }

                val keyboardController = LocalSoftwareKeyboardController.current
                BasicTextField(
                    value = query,
                    onValueChange = onQueryChange,
                    modifier = Modifier
                        .clearFocusOnKeyboardDismiss()
                        .weight(1f)
                        .onFocusChanged {
                            onSearchFocusChange(it.isFocused)
                        },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            Toast.makeText(ctx, "sdffsd", Toast.LENGTH_SHORT).show()
//                        onExecuteSearch()

                        keyboardController?.hide()
                        },
                    ),
                )

            }
        }
    }
}

private val IconSize = 48.dp

@Composable
private fun SearchHint() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    ) {
        Icon(
            imageVector = Icons.Outlined.Search,
            tint = DicTheme .colors.textHelp,
            contentDescription = stringResource(R.string.label_search)
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = stringResource(R.string.search_word),
            color = DicTheme .colors.textHelp
        )
    }
}

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
private fun SearchBarPreview() {
    DicTheme {
        DicSurface {
            SearchBar(
                query = "",
                onQueryChange = { },
                onSearchFocusChange = { },
                onClearQuery = { },
                enableClose = false
            )
        }
    }
}
