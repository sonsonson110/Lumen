package com.example.lumen.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lumen.ui.screens.alarm.AlarmScreen
import com.example.lumen.ui.screens.challenges.ChallengeScreen
import com.example.lumen.ui.screens.hobby.HobbyScreen
import com.example.lumen.ui.screens.home.HomeScreen
import com.example.lumen.ui.screens.meditate.MeditateScreen

@Composable
fun BuildNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(
            route = Screen.HomeScreen.route
        ) { HomeScreen() }

        composable(
            route = Screen.AlarmScreen.route
        ) { AlarmScreen() }

        composable(
            route = Screen.HobbyScreen.route
        ) { HobbyScreen() }

        composable(
            route = Screen.MeditateScreen.route
        ) { MeditateScreen() }

        composable(
            route = Screen.ChallengeScreen.route
        ) { ChallengeScreen() }
    }
}