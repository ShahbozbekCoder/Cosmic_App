package com.shahbozbek.cosmicapp

import android.widget.Toast
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    val isCheckboxChecked = remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.Transparent),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF091522).copy(0.6f)),
            border = CardDefaults.outlinedCardBorder(),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = "Profile image",
                    modifier = Modifier
                        .size(100.dp)
                        .weight(1f),
                    alignment = Alignment.TopStart
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f),
                ) {
                    Text(
                        text = "Arthur Dent",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(
                        text = "Space adventurer",
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.padding(16.dp))
                IconButton(
                    onClick = {
                        Toast.makeText(context, "Edit button clicked", Toast.LENGTH_SHORT)
                            .show()
                    },
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.Top)
                        .padding(end = 8.dp, top = 8.dp),
                ) {
                    Icon(
                        Icons.Default.Edit,
                        contentDescription = "Edit button",
                        modifier = Modifier
                            .size(32.dp),
                        tint = Color.White,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF091522).copy(0.6f)),
            border = CardDefaults.outlinedCardBorder(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(32.dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // Toggle Switch
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Switch(
                        checked = isCheckboxChecked.value,
                        onCheckedChange = {
                            isCheckboxChecked.value = it
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color(0xFF091522),
                            uncheckedThumbColor = Color(0xFF11DCE8),
                            checkedTrackColor = Color(0xFF11DCE8),
                            uncheckedTrackColor = Color(0xFF9E9E9E).copy(alpha = 0.5f)
                        ),
                        modifier = Modifier.width(70.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Show planetary progress",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))

                // Progress Circle
                Box(
                    modifier = Modifier.size(280.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        progress = { 0.871f },
                        modifier = Modifier
                            .size(280.dp),
                        strokeWidth = 12.dp, trackColor = Color.Gray,
                    )
                    Column(
                        modifier = Modifier.padding(bottom = 32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Personal \nprogress",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            fontSize = 26.sp
                        )
                        Text(
                            text = "87.1%",
                            fontSize = 70.sp,
                            color = Color(0xFF859AF4),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Options
                OptionItem(
                    text = "Show me in Planet Rating",
                    checked = true
                )
                OptionItem(
                    text = "Notifications",
                    checked = true
                )
            }
        }
    }
}
@Composable
fun OptionItem(text: String, checked: Boolean) {
    val isCheckboxChecked = remember { mutableStateOf(checked) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isCheckboxChecked.value,
            onCheckedChange = {
                isCheckboxChecked.value = it
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Black,
                uncheckedColor = Color.Gray,
                checkmarkColor = Color(0xFF11DCE8),
                disabledCheckedColor = Color.Gray
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.clickable {
                isCheckboxChecked.value = !isCheckboxChecked.value
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(navController = NavController(LocalContext.current))
}