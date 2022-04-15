package com.ronnie.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ronnie.presentation.components.MovieListItem


@Composable
fun ListScreen(navController: NavController) {
    LazyColumn() {
        items(10) {
            MovieListItem(navController)
        }
    }
}