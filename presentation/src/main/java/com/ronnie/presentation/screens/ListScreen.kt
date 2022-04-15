package com.ronnie.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.ronnie.presentation.components.MovieDetails
import com.ronnie.presentation.components.MovieListItem
import com.ronnie.presentation.components.ShimmerGridItem


@Composable
fun ListScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = { Text(text = "Movie App") }
            )
        },
        content = {
            LazyColumn() {
                items(10) {
                    MovieListItem(navController = navController)
//                    ShimmerGridItem(brush = Brush.linearGradient(
//                        listOf(
//                            Color.LightGray.copy(alpha = 0.9f),
//                            Color.LightGray.copy(alpha = 0.4f),
//                            Color.LightGray.copy(alpha = 0.9f)
//                        )
//                    )
//                    )
                }
            }
        })
}