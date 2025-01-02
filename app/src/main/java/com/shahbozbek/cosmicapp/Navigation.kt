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
    }
}