package com.amirhusseinsoori.persian_dictionary.ui.navigation


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amirhusseinsoori.persian_dictionary.ui.details.Details
import com.amirhusseinsoori.persian_dictionary.ui.intro.Intro
import com.amirhusseinsoori.persian_dictionary.ui.theme.DicTheme
import com.amirhusseinsoori.persian_dictionary.ui.words.WordScreen

import com.google.gson.Gson


@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun InitialNavGraph() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoute.IntroRoute.route) {
        addIntro(navController)
        WordNavigation(navController)
        DetailNavigation()
    }

}

@ExperimentalAnimationApi
fun NavGraphBuilder.addIntro(navController: NavController) {
    composable(NavRoute.IntroRoute.route) {
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
        route = NavRoute.WordRoute.route) {
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
        arguments = NavRoute.DetailsRoute.arguments) {
        Details()
    }
}