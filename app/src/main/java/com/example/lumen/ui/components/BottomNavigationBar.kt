package com.example.lumen.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lumen.R
import com.example.lumen.ui.navigation.Screen
import com.example.lumen.ui.theme.ChineseBlack
import com.example.lumen.ui.theme.MediumAquamarine
import com.example.lumen.ui.theme.PhilippineGray

val bottomItems = listOf<Screen>(
    Screen.HomeScreen,
    Screen.AlarmScreen,
    Screen.HobbyScreen,
    Screen.MeditateScreen,
    Screen.ChallengeScreen,
)

@Composable
fun LumenBottomBar(navController: NavHostController) {
    BottomAppBar(backgroundColor = MediumAquamarine, modifier = Modifier.height(80.dp)) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        bottomItems.forEach { item ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                icon = {
                    val icon = when (item) {
                        is Screen.HomeScreen -> R.drawable.rounded_home_24
                        is Screen.AlarmScreen -> R.drawable.outline_access_alarm_24
                        is Screen.HobbyScreen -> R.drawable.outline_directions_run_24
                        is Screen.MeditateScreen -> R.drawable.baseline_self_improvement_24
                        is Screen.ChallengeScreen -> R.drawable.outline_trophy_24
                        else -> 0
                    }
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                },
                label = { Text(item.label, fontSize = 10.sp) },
                selectedContentColor = ChineseBlack,
                unselectedContentColor = PhilippineGray
            )
        }
    }
}

@Preview
@Composable
fun PreviewBottomBar() {
    LumenBottomBar(navController = rememberNavController())
}