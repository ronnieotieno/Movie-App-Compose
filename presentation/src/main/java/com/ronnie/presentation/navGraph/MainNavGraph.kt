package com.ronnie.presentation.navGraph

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
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
    AnimatedNavHost(navController, startDestination = Screen.List.route,
        enterTransition = {EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }) {
        composable(route = Screen.List.route) {
            ListScreen(navController)
        }
        composable(route = Screen.Detail.route) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")
            requireNotNull(movieId) { "Movie parameter wasn't found. Please make sure it's set!" }
            DetailScreen(navController, movieId)
        }
    }
}
