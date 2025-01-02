package com.shahbozbek.cosmicapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlanetItem(planets: List<String>, index: Int, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .height(55.dp)
            .width(intrinsicSize = IntrinsicSize.Max)
            .padding(end = 12.dp),
        shape = RoundedCornerShape(50),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF091522).copy(0.6f)),
        border = CardDefaults.outlinedCardBorder(),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.planet),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
            )
            Text(
                text = planets[index],
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(end = 16.dp)
            )
        }
    }

}
