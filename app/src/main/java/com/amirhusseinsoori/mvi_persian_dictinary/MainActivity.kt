package com.amirhusseinsoori.mvi_persian_dictinary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi

import androidx.navigation.NavHostController
import com.amirhusseinsoori.mvi_persian_dictinary.ui.navigation.InitialNavGraph
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {



    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {


                    InitialNavGraph()
        }
    }
}


