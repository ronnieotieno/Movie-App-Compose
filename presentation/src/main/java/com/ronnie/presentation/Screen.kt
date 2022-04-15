package com.ronnie.presentation

sealed class Screen(val route: String) {
	object List: Screen("list")
	object Detail: Screen("{movie}/detail")
	fun createRoute(movie: String) = "$movie/detail"
}