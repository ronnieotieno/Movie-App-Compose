package com.ronnie.domain.repository

import androidx.paging.PagingData
import com.ronnie.domain.model.NetworkResult
import com.ronnie.domain.model.movieDetail.MovieDetailResponse
import com.ronnie.domain.model.uiView.MovieView
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getMovies(): Flow<PagingData<MovieView>>
    suspend fun getMovieDetails(id: Int): NetworkResult<MovieDetailResponse>
}