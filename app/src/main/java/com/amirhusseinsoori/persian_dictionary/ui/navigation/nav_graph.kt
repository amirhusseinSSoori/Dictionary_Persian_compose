package com.amirhusseinsoori.persian_dictionary.ui.navigation


import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.amirhusseinsoori.persian_dictionary.ui.details.Details
import com.amirhusseinsoori.persian_dictionary.ui.intro.Intro
import com.amirhusseinsoori.persian_dictionary.ui.theme.DicTheme
import com.amirhusseinsoori.persian_dictionary.ui.words.WordScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.gson.Gson


@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun InitialNavGraph() {
    val navController: NavHostController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, startDestination = NavRoute.IntroRoute.route) {
        addIntro(navController)
        WordNavigation(navController)
        DetailNavigation()
    }

}

@ExperimentalAnimationApi
fun NavGraphBuilder.addIntro(navController: NavController) {
    composable(NavRoute.IntroRoute.route,
        enterTransition = {
            when (initialState.destination.route) {
                NavRoute.WordRoute.route ->
                    slideInHorizontally(
                        initialOffsetX = { 300 },
                        animationSpec = tween(300)
                    ) + fadeIn(animationSpec = tween(300))
                else -> null
            }
        },
        exitTransition = {
            when (initialState.destination.route) {
                NavRoute.WordRoute.route ->
                    slideOutHorizontally(
                        targetOffsetX = { 300 },
                        animationSpec = tween(300)
                    ) + fadeOut(animationSpec = tween(300))
                else -> null
            }
        },
        popEnterTransition = {
            when (initialState.destination.route) {
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

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
fun NavGraphBuilder.WordNavigation(
    navController: NavController
) {

    composable(
        route = NavRoute.WordRoute.route,
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { 300 },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(300))
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { 300 },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(animationSpec = tween(300))
        },
    ) {
        DicTheme {
            WordScreen(navigateToDetailsScreen = {
                navController.navigate("${NavRoute.DetailsRoute.route}/${Gson().toJson(it)}")
            })
        }

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
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { -300 },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(animationSpec = tween(300))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -300 },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(300))
        }
    ) {
        Details()
    }
}