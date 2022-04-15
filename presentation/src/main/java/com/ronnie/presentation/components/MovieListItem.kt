package com.ronnie.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ronnie.presentation.R
import com.ronnie.presentation.Screen
import com.ronnie.presentation.viewmodels.MovieViewModel

@Composable
fun MovieListItem(navController: NavController, viewModel:MovieViewModel = hiltViewModel()) {
    Box(
        Modifier
            .clickable { navController.navigate(Screen.Detail.createRoute(viewModel.uiState)) }
            .fillMaxWidth()) {
        Row(
            Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.sample),
                contentDescription = "movie Image",
                modifier = Modifier
                    .height(110.dp)
                    .width(110.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxHeight()
                    .align(CenterVertically),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Sonic the Hedgehog 2", color = Color.Black, fontSize = 14.sp)
                Spacer(Modifier.height(10.dp))
                Text(text = "2022", color = Color.DarkGray, fontSize = 14.sp)
                Spacer(Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(R.drawable.star),
                        contentDescription = "rating",
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "7.7", color = Color.DarkGray, fontSize = 14.sp,
                        modifier = Modifier.padding(top = 0.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .height(0.7.dp)
        )
    }
}