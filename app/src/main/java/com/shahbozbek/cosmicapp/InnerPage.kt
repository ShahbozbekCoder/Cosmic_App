package com.shahbozbek.cosmicapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InnerPage() {
    val isSelected = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.inner_back),
                contentScale = ContentScale.Crop
            )
    ) {
        // UI elements for the inner page
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp, start = 32.dp, end = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(50.dp),
                shape = CircleShape,
                elevation = CardDefaults.cardElevation(2.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF091522).copy(0.5f)),
                border = CardDefaults.outlinedCardBorder()
            ) {
                IconButton(onClick = { /* Handle back button click */ }) {
                    Icon(
                        Icons.Default.ArrowBack, contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
            Card(
                modifier = Modifier.size(50.dp),
                shape = CircleShape,
                elevation = CardDefaults.cardElevation(2.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF091522).copy(0.5f)),
                border = CardDefaults.outlinedCardBorder()
            ) {
                IconButton(onClick = { isSelected.value = !isSelected.value }) {
                    Icon(
                        if (!isSelected.value) Icons.Default.FavoriteBorder else Icons.Default.Favorite,
                        contentDescription = "Share",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(64.dp))
        Card(
            modifier = Modifier
                .fillMaxSize()
                .height(540.dp)
                .verticalScroll(rememberScrollState()),
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF091522).copy(0.5f) // Shaffof fon uchun
            ),
            border = CardDefaults.outlinedCardBorder()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Earth",
                    color = Color.White,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                )
                val icons = listOf(
                    R.drawable.mass,
                    R.drawable.gravity,
                    R.drawable.day
                )
                val quantities = listOf(
                    "Mass",
                    "Gravity",
                    "Day"
                )
                val units = listOf(
                    "(10^24 kg)",
                    "(m/s^2)",
                    "(hours)"
                )
                val values = listOf(
                    "5.97",
                    "9.8",
                    "24"
                )
                RowItem(icons = icons, quantities = quantities, units = units, values = values)
                Spacer(modifier = Modifier.height(16.dp))
                val icons2 = listOf(
                    R.drawable.velocity,
                    R.drawable.temp,
                    R.drawable.distance
                )

                val quantities2 = listOf(
                    "Esc. Velocity",
                    "Mean",
                    "Distance from"
                )
                val units2 = listOf(
                    "(km/s)",
                    "Temp (C)",
                    "Sun (106 km)"
                )
                val values2 = listOf(
                    "11.2",
                    "15",
                    "5.97"
                )
                RowItem(icons = icons2, quantities = quantities2, units = units2, values = values2)
            }
        }
    }
}

@Composable
fun RowItem(icons: List<Int>, quantities: List<String>, units: List<String>, values: List<String>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in icons.indices) {
            ColumnItem(icon = icons[i], quantity = quantities[i], unit = units[i], value = values[i])
        }
//        ColumnItem(icon = R.drawable.mass, quantity = "Mass", unit = "(10^24 kg)", value = "5.97")
//        ColumnItem(icon = R.drawable.gravity, quantity = "Gravity", unit = "(m/s^2)", value = "9.8")
//        ColumnItem(icon = R.drawable.day, quantity = "Day", unit = "(hours)", value = "24")
    }
}

@Composable
fun ColumnItem(
    icon: Int,
    quantity: String,
    unit: String,
    value: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Earth",
            tint = Color.White,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = quantity,
            color = Color.White
        )
        Text(text = unit)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = value,
            color = Color.White,
            fontSize = 24.sp
        )
    }
}

//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun InnerPagePreview() {
//    InnerPage()
//}