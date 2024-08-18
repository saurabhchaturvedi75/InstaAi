package com.example.appinstaai.navigation
sealed class Routes(val route: String) {

    data object Home : Routes("home")
    data object Reels : Routes("reels")
    data object Add : Routes("add")
    data object Play : Routes("play")

    data object Profile : Routes("profile")
    data object Message : Routes("message")



    data object BottomNavigation : Routes("bottomNavigation")



}
