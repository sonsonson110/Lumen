package com.example.lumen.ui.navigation

sealed class Screen(val route: String) {
    data object HomeScreen : Screen(route = "home_screen")
    data object AlarmScreen: Screen(route = "alarm_screen")
    data object HobbyScreen: Screen(route = "hobby_screen")
    data object MeditateScreen: Screen(route = "meditate_screen")
    data object ChallengeScreen: Screen(route = "challenge_screen")
}