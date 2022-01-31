package com.amirhusseinsoori.mvi_persian_dictinary.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.NamedNavArgument
import androidx.navigation.navArgument

sealed class NavRoute(var route: String,val arguments: List<NamedNavArgument>) {
    object IntroRoute : NavRoute("Intro_screen", emptyList())
    object WordRoute : NavRoute("Word_screen",emptyList())
    object DetailsRoute : NavRoute("Details_screen",
        arguments = listOf(navArgument("details") {
            type = NavType.StringType
        })
    )
}