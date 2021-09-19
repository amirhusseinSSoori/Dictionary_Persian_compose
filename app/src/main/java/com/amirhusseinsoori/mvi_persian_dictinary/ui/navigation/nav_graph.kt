package com.amirhusseinsoori.mvi_persian_dictinary.ui.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.amirhusseinsoori.mvi_persian_dictinary.ui.intro.Intro

import com.amirhusseinsoori.mvi_persian_dictinary.ui.main.WordScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun InitialNavGraph(navController: NavHostController){

    val scope = rememberCoroutineScope()
    AnimatedNavHost(navController = navController, startDestination = NavRoute.IntroRoute.route){
        composable(NavRoute.IntroRoute.route,
            enterTransition = { initial, _ ->
                when (initial.destination.route) {
                    NavRoute.WordRoute.route ->
                        slideInHorizontally(
                            initialOffsetX = { 300 },
                            animationSpec = tween(300)
                        ) + fadeIn(animationSpec = tween(300))
                    else -> null
                }
            },
            exitTransition = { _, target ->
                when (target.destination.route) {
                    NavRoute.WordRoute.route ->
                        slideOutHorizontally(
                            targetOffsetX = { 300 },
                            animationSpec = tween(300)
                        ) + fadeOut(animationSpec = tween(300))
                    else -> null
                }
            },
            popEnterTransition = { initial, _ ->
                when (initial.destination.route) {
                    NavRoute.WordRoute.route ->
                        slideInHorizontally(
                            initialOffsetX = { 300 },
                            animationSpec = tween(300)
                        ) + fadeIn(animationSpec = tween(300))
                    else -> null
                }
            }) {
            Intro()
            scope.launch {
                delay(3000)
                navController.navigate(NavRoute.WordRoute.route) {
                    popUpTo(NavRoute.IntroRoute.route)
                    popUpTo(NavRoute.IntroRoute.route) { inclusive = true }
                    launchSingleTop = true
                }
            }

        }


        WordScreen(navController)
    }

}


@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
fun NavGraphBuilder.WordScreen(
    navController: NavController
) {
    composable(
        route = NavRoute.WordRoute.route,
        exitTransition = { _, _ ->
            slideOutHorizontally(
                targetOffsetX = { 300 },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(300))
        },
        popEnterTransition = { initial, _ ->
            slideInHorizontally(
                initialOffsetX = { 300 },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(animationSpec = tween(300))
        },
    ) {
        WordScreen()
    }
}