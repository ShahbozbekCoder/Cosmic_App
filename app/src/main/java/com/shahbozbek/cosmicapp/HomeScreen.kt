package com.shahbozbek.cosmicapp

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val context = LocalContext.current
    var selectedItem by remember { mutableStateOf("Home") }
    Scaffold(topBar = {
        TopAppBar(modifier = Modifier
            .height(120.dp)
            .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)), title = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Milky way", color = Color(0xFF8E8D99), fontSize = 10.sp
                )
                Text(
                    text = "Solar system",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }, navigationIcon = {
            IconButton(
                onClick = {
                    Toast.makeText(context, "Menu clicked", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(60.dp)
            ) {
                Icon(
                    Icons.Default.Menu, contentDescription = "Menu", tint = Color.White
                )
            }
        }, actions = {
            IconButton(
                onClick = {
                    Toast.makeText(context, "Account clicked", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(60.dp)
            ) {
                Icon(
                    Icons.Default.AccountCircle,
                    contentDescription = "Account",
                    tint = Color.White
                )
            }
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF091522).copy(0.6f)
        )
        )
    }, bottomBar = {
        BottomAppBar(
            containerColor = Color(0xFF091522).copy(0.6f),
            tonalElevation = 2.dp,
            modifier = Modifier.clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    IconButton(onClick = {
                        /* Handle action click */
                        selectedItem = "Home"

                    }) {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = "Home",
                            tint = if (selectedItem == "Home") Color(0xFF11DCE8) else Color(
                                0xFF9E9E9E
                            )
                        )
                    }
                    Text(
                        text = "Home",
                        color = if (selectedItem == "Home") Color.White else Color(
                            0xFF9E9E9E
                        )
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    IconButton(onClick = {
                        selectedItem = "Favorites"
                    }) {
                        Icon(
                            Icons.Default.FavoriteBorder,
                            contentDescription = "Favorites",
                            tint = if (selectedItem == "Favorites") Color(0xFF11DCE8) else Color(
                                0xFF9E9E9E
                            )
                        )
                    }
                    Text(
                        text = "Favorites",
                        color = if (selectedItem == "Favorites") Color.White else Color(
                            0xFF9E9E9E
                        )
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    IconButton(onClick = {
                        selectedItem = "More"
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.more_horiz),
                            contentDescription = "More",
                            tint = if (selectedItem == "More") Color(0xFF11DCE8) else Color(
                                0xFF9E9E9E
                            )
                        )
                    }
                    Text(
                        text = "More",
                        color = if (selectedItem == "More") Color.White else Color(
                            0xFF9E9E9E
                        )
                    )
                }
            }
        }
    }) { padding ->
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        HomeContent(padding)
    }

}

@Composable
fun HomeContent(padding: PaddingValues) {
    val planets = listOf(
        "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"
    )
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(padding)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyRow(
            modifier = Modifier.padding(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp
            )
        ) {
            items(planets.size) { index ->
                PlanetItem(planets = planets, index = index, onClick = {
                    Toast.makeText(context, planets[index], Toast.LENGTH_SHORT).show()
                })
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF091522).copy(0.6f)),
            border = CardDefaults.outlinedCardBorder()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Planet of the day",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.planet_2),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Mars",
                            color = Color(0xFF11DCE8),
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System, only being larger than Mercury. In the English language, Mars is named for the Roman god of war.",
                            color = Color.White,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {

                        },
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Details",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_right_alt),
                        contentDescription = null,
                        tint = Color(0xFF11DCE8),
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
        Card(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF091522).copy(0.6f)),
            border = CardDefaults.outlinedCardBorder()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Solar system",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                )
                Text(
                    text = "The Solar System[c] is the gravitationally bound system of the Sun and" +
                            " the objects that orbit it. It formed 4.6 billion years ago from the" +
                            " gravitational collapse of a giant interstellar molecular cloud." +
                            " The vast majority (99.86%) of the system's mass is in the Sun, with" +
                            " most of the remaining mass contained in the planet Jupiter. The four" +
                            " inner system planets—Mercury, Venus, Earth and Mars—are terrestrial" +
                            " planets, being composed primarily of rock and metal. The four giant" +
                            " planets of the outer system are substantially larger and more massive" +
                            " than the terrestrials. ",
                    color = Color.White,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun HomeScreenPreview() {
//    HomeScreen()
//}