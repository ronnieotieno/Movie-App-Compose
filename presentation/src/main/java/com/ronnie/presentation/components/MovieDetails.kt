package com.ronnie.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ronnie.presentation.R
import com.ronnie.presentation.theme.Teal200

@Composable
fun MovieDetails() {
    val detail =
        "The tale of an extraordinary family, the Madrigals, who live hidden in the mountains of Colombia, in a magical house, in a vibrant town, in a wondrous, charmed place called an Encanto. The magic of the Encanto has blessed every child in the family with a unique gift from super strength to the power to heal—every child except one, Mirabel. But when she discovers that the magic surrounding the Encanto is in danger, Mirabel decides that she, the only ordinary Madrigal, might just be her exceptional family's last hope."
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.sample),
            contentDescription = "movie Image",
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Fit
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column {
                Spacer(Modifier.height(10.dp))
                Text(
                    text = "Sonic the Hedgehog 2",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(10.dp))
                Text(text = "2022", color = Color.DarkGray, fontSize = 14.sp)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp)
                    .align(Alignment.CenterVertically),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "7.7",
                    color = Teal200,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "/10",
                    color = Color.DarkGray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(Modifier.height(10.dp))
        LazyRow() {
            items(10) {
              GenreChip()
            }
        }
        Spacer(Modifier.height(10.dp))
        Text(text = detail, color = Color.DarkGray, fontSize = 14.sp)
    }
}