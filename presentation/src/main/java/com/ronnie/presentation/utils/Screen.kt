package com.ronnie.presentation.utils

sealed class Screen(val route: String) {
    object List : Screen("list")
    object Detail : Screen("{movieId}/detail")

    fun createRoute(movieId: String) = "$movieId/detail"
}