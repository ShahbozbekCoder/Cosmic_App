package com.shahbozbek.cosmicapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.img),
                contentScale = ContentScale.Crop
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // UI elements for login screen
        Spacer(modifier = Modifier.height(68.dp))
        Image(
            painter = painterResource(id = R.drawable.cosmic_2),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(68.dp))
        Box(
            modifier = Modifier.fillMaxSize().wrapContentHeight(Alignment.Bottom),
            contentAlignment = Alignment.BottomCenter
        ) {
            Card(
                modifier = Modifier
                    .wrapContentHeight(align = Alignment.Bottom)
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
                        text = "Sign in",
                        fontSize = 36.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        value = email.value,
                        onValueChange = { email.value = it },
                        placeholder = {
                            Text(
                                "Email",
                                color = Color(0xFF8D8E99)
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(50),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFF091522),
                            focusedIndicatorColor = Color.White,
                            unfocusedIndicatorColor = Color(0xFF3A3A42),
                            cursorColor = Color.White,
                        ),
                        textStyle = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        value = password.value,
                        onValueChange = { password.value = it },
                        placeholder = {
                            Text(
                                "Password",
                                color = Color(0xFF8D8E99)
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(50),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFF091522),
                            focusedIndicatorColor = Color.White,
                            unfocusedIndicatorColor = Color(0xFF3A3A42),
                            cursorColor = Color.White,
                        ),
                        textStyle = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Forgot Password?",
                        color = Color(0xFF11DCE8),
                        fontSize = 22.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xFFE961FF),
                                        Color(0xFF72A5F2),
                                        Color(0xFF00E5E5)

                                    )
                                ),
                                shape = RoundedCornerShape(50)
                            )
                            .clickable {
                                navController.navigate("home_screen")
                            },
                        contentAlignment = Alignment.Center,
                        content = {
                            Text(
                                text = "Sign in",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        HorizontalDivider(
                            modifier = Modifier
                                .padding(end = 16.dp, top = 10.dp)
                                .weight(1f)
                                .alignByBaseline()
                                .height(1.dp),
                            color = Color(0xFF8D8E99)
                        )
                        Text(
                            text = "or sign in using",
                            fontSize = 16.sp,
                            color = Color(0xFFC4C4C4),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.alignByBaseline()
                        )
                        HorizontalDivider(
                            modifier = Modifier
                                .padding(start = 16.dp, top = 10.dp)
                                .weight(1f)
                                .alignByBaseline()
                                .height(1.dp),
                            color = Color(0xFF8D8E99)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .clickable {

                                },
                            contentAlignment = Alignment.Center,
                            content = {
                                Image(
                                    painter = painterResource(id = R.drawable.twitter),
                                    contentDescription = "Twitter",
                                    modifier = Modifier.size(100.dp)
                                )
                            }
                        )
                        Box(
                            modifier = Modifier
                                .clickable {

                                },
                            contentAlignment = Alignment.Center,
                            content = {
                                Image(
                                    painter = painterResource(id = R.drawable.facebook),
                                    contentDescription = "Facebook",
                                    modifier = Modifier.size(100.dp)
                                )
                            }
                        )
                        Box(
                            modifier = Modifier
                                .clickable {

                                },
                            contentAlignment = Alignment.Center,
                            content = {
                                Image(
                                    painter = painterResource(id = R.drawable.google),
                                    contentDescription = "Google",
                                    modifier = Modifier.size(100.dp)
                                )
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Don't have an account?",
                            color = Color(0xFF9E9E9E),
                            fontSize = 15.sp
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            text = "Sign up",
                            color = Color(0xFF11DCE8),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.clickable {

                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = NavController(LocalContext.current))
}