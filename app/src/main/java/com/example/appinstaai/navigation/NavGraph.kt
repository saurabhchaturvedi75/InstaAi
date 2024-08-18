package com.example.appinstaai.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appinstaai.screen.AddScreen
import com.example.appinstaai.screen.HomeScreen
import com.example.appinstaai.screen.MessageScreen
import com.example.appinstaai.screen.PlayScreen
import com.example.appinstaai.screen.ProfileScreen
import com.example.appinstaai.screen.ReelsScreen


@Composable
fun NavGraph(navController: NavHostController) {


    NavHost(navController = navController, startDestination = Routes.BottomNavigation.route) {


        composable(Routes.BottomNavigation.route) {
            BottomNav(navController)
        }
        composable(Routes.Home.route) {
            HomeScreen(navController)
        }
        composable(Routes.Reels.route) {
            ReelsScreen(navController)
        }
        composable(Routes.Add.route) {
            AddScreen(navController)
        }
        composable(Routes.Play.route) {
            PlayScreen(navController)
        }
        composable(Routes.Profile.route) {
            ProfileScreen(navController)
        }
        composable(Routes.Message.route) {
            MessageScreen(navController)
        }



    }
}