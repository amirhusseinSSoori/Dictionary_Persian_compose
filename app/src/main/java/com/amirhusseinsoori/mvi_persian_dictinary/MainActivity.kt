package com.amirhusseinsoori.mvi_persian_dictinary

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.media.AudioManager
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager

import androidx.navigation.NavHostController
import com.amirhusseinsoori.mvi_persian_dictinary.common.KeyBoardManager
import com.amirhusseinsoori.mvi_persian_dictinary.ui.navigation.InitialNavGraph
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @ExperimentalMaterialApi
    @ExperimentalFoundationApi
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



