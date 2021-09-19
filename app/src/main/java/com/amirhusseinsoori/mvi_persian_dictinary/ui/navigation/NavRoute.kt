package com.amirhusseinsoori.mvi_persian_dictinary.ui.navigation

sealed class NavRoute(var route: String) {
    object IntroRoute : NavRoute("Intro_screen")
    object WordRoute : NavRoute("Word_screen")
}