package com.shahbozbek.cosmicapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {
        composable("splash_screen") { SplashScreen(navController = navController) }
        composable("login_screen") { LoginScreen(navController = navController) }
        composable("home_screen") { HomeScreen() }
        /*composable(
            "inner_page/{planetName}",
            arguments = listOf(navArgument("planetName") { type = NavType.StringType })
        ) { backStackEntry ->
            val planetName = backStackEntry.arguments?.getString("planetName") ?: ""
            InnerPage(navController = navController, planetName = planetName)
        }
        composable("favorites_screen") { FavoritesScreen(navController = navController) }
*/
    }
}