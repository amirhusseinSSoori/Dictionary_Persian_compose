package com.amirhusseinsoori.persian_dictionary

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import com.amirhusseinsoori.persian_dictionary.common.KeyBoardManager
import com.amirhusseinsoori.persian_dictionary.ui.navigation.InitialNavGraph
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppKeyboardFocusManager()
            InitialNavGraph()
        }
    }
}

@Composable
fun AppKeyboardFocusManager() {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    DisposableEffect(key1 = context) {
        val keyboardManager = KeyBoardManager(context)
        keyboardManager.attachKeyboardDismissListener {
            focusManager.clearFocus()
        }
        onDispose {
            keyboardManager.release()
        }
    }
}



