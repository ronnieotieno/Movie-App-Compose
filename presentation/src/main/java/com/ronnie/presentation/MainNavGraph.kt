package com.ronnie.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ronnie.presentation.screens.DetailScreen
import com.ronnie.presentation.screens.ListScreen

@Composable
@ExperimentalAnimationApi
fun MainNavGraph() {
    val navController = rememberNavController()
   NavHost(navController, startDestination = Screen.List.route) {
        composable(route = Screen.List.route) {
            ListScreen(navController)
        }
        composable(route = Screen.Detail.route) { backStackEntry ->
            val movie = backStackEntry.arguments?.getString("movie")
            requireNotNull(movie) { "Movie parameter wasn't found. Please make sure it's set!" }
            DetailScreen(navController, movie)
        }
    }
}