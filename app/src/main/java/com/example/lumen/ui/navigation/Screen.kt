package com.example.lumen.ui.navigation

sealed class Screen(val route: String, val label: String) {
    data object HomeScreen : Screen(route = "home_screen", label = "Home")
    data object AlarmScreen: Screen(route = "alarm_screen", label = "Alarm")
    data object HobbyScreen: Screen(route = "hobby_screen", label = "Hobby")
    data object MeditateScreen: Screen(route = "meditate_screen", label = "Meditate")
    data object ChallengeScreen: Screen(route = "challenge_screen", label = "Challenge")
}