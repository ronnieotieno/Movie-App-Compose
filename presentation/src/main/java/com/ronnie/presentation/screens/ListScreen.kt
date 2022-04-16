package com.ronnie.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.ronnie.presentation.components.MovieListItem
import com.ronnie.presentation.viewmodels.ListViewModel


@Composable
fun ListScreen(navController: NavController, viewModel: ListViewModel = hiltViewModel()) {
    val lazyMovieItems = viewModel.getMovies().collectAsLazyPagingItems()
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = { Text(text = "Movie App") }
            )
        },
        content = {
            LazyColumn() {
                items(lazyMovieItems.itemCount) { index ->
                    lazyMovieItems[index]?.let { movie ->
                        MovieListItem(navController = navController, movie)
                    }
                }
            }
        })
}