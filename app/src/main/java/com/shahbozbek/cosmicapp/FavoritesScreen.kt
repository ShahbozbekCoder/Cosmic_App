package com.shahbozbek.cosmicapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun FavoritesScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        val planets = listOf(
            "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"
        )
        val aboutPlanets = listOf(
            "Mercury is the smallest planet in the Solar System and the closest to the Sun.",
            "Venus is a rocky planet with a thick atmosphere, often compared to Earth's atmosphere.",
            "Earth is the only planet known to support life. It is home to millions of diverse life forms.",
            "Mars is known as the Red Planet due to its reddish appearance. It is often compared to Earth's proximity.",
            "Jupiter is a gas giant with a massive storm known as the Great Red Spot.",
            "Saturn is known for its prominent ring system, which is made up of ice particles.",
            "Uranus is an ice giant with a unique sideways rotation, similar to Jupiter.",
            "Neptune is a distant ice giant with a blue color due to its deep blue coloration"
        )
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(planets.size) { index ->
                FavoritesItem(
                    planets = planets,
                    index = index,
                    aboutPlanets = aboutPlanets
                )
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FavoritesScreenPreview() {
    FavoritesScreen(navController = NavController(LocalContext.current))
}