package com.ronnie.presentation.screens

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.ronnie.presentation.components.MovieDetails

@Composable
fun DetailScreen(navController: NavController, movie:String) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = { Text(text = movie) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        content = {
            MovieDetails()
        })
}