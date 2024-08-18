package com.example.appinstaai.navigation


import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.border
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.PlayCircleOutline
import androidx.compose.material.icons.outlined.SmartDisplay
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appinstaai.screen.AddScreen
import com.example.appinstaai.screen.HomeScreen
import com.example.appinstaai.screen.MessageScreen
import com.example.appinstaai.screen.PlayScreen
import com.example.appinstaai.screen.ProfileScreen
import com.example.appinstaai.screen.ReelsScreen

@Composable
fun BottomNav(navController: NavHostController) {

    val navController1 = rememberNavController()

    Scaffold(bottomBar = { MyBottomBar(navController1) }) { padding ->
        NavHost(
            navController = navController1, startDestination = Routes.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Routes.Home.route) {
                HomeScreen(navController1)
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
                MessageScreen(navController1)
            }


        }

    }
}


@Composable
fun MyBottomBar(navController1: NavHostController) {

    val backStackEntry = navController1.currentBackStackEntryAsState()

    val list = listOf(
        BottomNavItem(
            Routes.Home.route,
            Icons.Outlined.Home,
            modifier = Modifier
                .size(25.dp)
        ),
        BottomNavItem(
            Routes.Reels.route,
            Icons.Outlined.PlayCircleOutline,
            modifier = Modifier
                .size(25.dp)
        ),
        BottomNavItem(
            Routes.Add.route,
            Icons.Outlined.Add,
            modifier = Modifier
                .size(40.dp)

                .border(
                    width = 2.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(Color.Blue, Color.Cyan)
                    ),  shape = CircleShape
                )
            .padding(10.dp)
        ),
        BottomNavItem(
            Routes.Play.route,
            Icons.Outlined.SmartDisplay,
            modifier = Modifier
                .size(25.dp)
        ),
        BottomNavItem(
            Routes.Profile.route,
            Icons.Outlined.PersonOutline,
            modifier = Modifier
                .size(25.dp)
        ),

    )
    CompositionLocalProvider(
        LocalIndication provides rememberRipple(
            bounded = false,
            radius = 10.dp, // Adjust the radius as needed
            color = Color.LightGray // Customize the color
        )
    ) {
    BottomAppBar(
        containerColor = Color.White, // Set the desired color
        modifier = Modifier.height(120.dp) // Set the desired height
    ) {
        list.forEach {
            val selected = it.route == backStackEntry.value?.destination?.route

            NavigationBarItem(
            //    alwaysShowLabel = true,
              //  label = { Text(it.title) },
                selected = selected, onClick = {
                    navController1.navigate(it.route) {
                        popUpTo(navController1.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                }, icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = null,
                        modifier = it.modifier
                    )
                },
                        modifier = Modifier.indication(
                        interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    bounded = true,
                    radius = 100.dp, // Adjust the radius as needed
                    color = Color.LightGray // Customize the color
                )
            )
            )
        }
    }
    }
}