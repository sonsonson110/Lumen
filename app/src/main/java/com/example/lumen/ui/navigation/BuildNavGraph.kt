package com.example.lumen.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lumen.ui.screens.alarm.AlarmScreen
import com.example.lumen.ui.screens.challenges.ChallengeScreen
import com.example.lumen.ui.screens.hobby.HobbyScreen
import com.example.lumen.ui.screens.home.HomeScreen
import com.example.lumen.ui.screens.home.MoodCheckScreen
import com.example.lumen.ui.screens.meditate.MeditateScreen

@Composable
fun BuildNavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(
                modifier,
                navigateToMoodCheckScreen = { navController.navigate(route = Screen.MoodCheckScreen.route) }
            )
        }

        composable(
            route = Screen.MoodCheckScreen.route
        ) {
            MoodCheckScreen(modifier, onNavigateUp = { navController.popBackStack() })
        }

        composable(
            route = Screen.AlarmScreen.route
        ) { AlarmScreen(modifier) }

        composable(
            route = Screen.HobbyScreen.route
        ) { HobbyScreen(modifier) }

        composable(
            route = Screen.MeditateScreen.route
        ) { MeditateScreen(modifier) }

        composable(
            route = Screen.ChallengeScreen.route
        ) { ChallengeScreen(modifier) }
    }
}