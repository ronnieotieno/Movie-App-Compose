package com.ronnie.domain.model

import com.ronnie.domain.model.uiView.MovieDetail

data class UiState(
    val isLoading: Boolean = false,
    val data: MovieDetail? = null,
    val error: Boolean = false
)