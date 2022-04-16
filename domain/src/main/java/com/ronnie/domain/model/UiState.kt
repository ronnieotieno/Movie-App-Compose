package com.ronnie.domain.model

import com.ronnie.domain.model.movieDetail.MovieDetailResponse

data class UiState(
    val isLoading: Boolean = false,
    val data: MovieDetailResponse? = null,
    val error: Boolean = false
)