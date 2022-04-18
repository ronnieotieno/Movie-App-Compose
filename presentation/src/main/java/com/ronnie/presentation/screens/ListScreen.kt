package com.ronnie.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.ronnie.presentation.components.ErrorView
import com.ronnie.presentation.components.LoadingShimmerEffect
import com.ronnie.presentation.components.MovieListItem
import com.ronnie.presentation.viewmodels.ListViewModel

@Composable
fun ListScreen(navController: NavController, viewModel: ListViewModel = hiltViewModel()) {
    val lazyMovieItems = remember {
        viewModel.movieList
    }.collectAsLazyPagingItems()

    val listState = rememberLazyListState()
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = { Text(text = "Movie App") }
            )
        }
    ) {
        if (lazyMovieItems.loadState.refresh is LoadState.Error) {
            ErrorView { lazyMovieItems.retry() }
        }
        LazyColumn(state = listState) {
            if (lazyMovieItems.loadState.refresh is LoadState.Loading) {
                items(10) {
                    LoadingShimmerEffect()
                }
            }
            items(lazyMovieItems.itemCount) { index ->
                lazyMovieItems[index]?.let { movie ->
                    MovieListItem(navController = navController, movie)
                }
            }
        }
    }
}