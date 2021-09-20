package com.amirhusseinsoori.mvi_persian_dictinary.ui.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amirhusseinsoori.mvi_persian_dictinary.ui.details.Details
import com.amirhusseinsoori.mvi_persian_dictinary.ui.intro.Intro
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.DicTheme
import com.amirhusseinsoori.mvi_persian_dictinary.ui.words.WordScreen

import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun InitialNavGraph(){
    val navController: NavHostController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, startDestination = NavRoute.IntroRoute.route){
        addIntro(navController)
        WordNavigation(navController)
        DetailNavigation()
    }

}

@ExperimentalAnimationApi
fun NavGraphBuilder.addIntro(navController: NavController) {
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
        Intro(navController)
    }
}

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
fun NavGraphBuilder.WordNavigation(
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
        WordScreen(navigateToDetailsScreen={
            navController.navigate("${NavRoute.DetailsRoute.route}/$it")
        })
    }
}

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
fun NavGraphBuilder.DetailNavigation(
) {
    composable(
        route = NavRoute.DetailsRoute.route + "/{details}",
        arguments = NavRoute.DetailsRoute.arguments,
        enterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = { -300 },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(animationSpec = tween(300))
        },
        popExitTransition = { _, target ->
            slideOutHorizontally(
                targetOffsetX = { -300 },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(300))
        }
    ) {
        Details("${it.arguments?.get("details")}")
    }
}