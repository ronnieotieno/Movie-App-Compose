package com.ronnie.presentation.navGraph

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.ronnie.presentation.screens.DetailScreen
import com.ronnie.presentation.screens.ListScreen
import com.ronnie.presentation.utils.Screen

@Composable
@ExperimentalAnimationApi
fun MainNavGraph() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController, startDestination = Screen.List.route) {
        composable(route = Screen.List.route) {
            ListScreen(navController)
        }
        composable(route = Screen.Detail.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(500)
                )
            }) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")
            requireNotNull(movieId) { "Movie parameter wasn't found. Please make sure it's set!" }
            DetailScreen(navController, movieId)
        }
    }
}
