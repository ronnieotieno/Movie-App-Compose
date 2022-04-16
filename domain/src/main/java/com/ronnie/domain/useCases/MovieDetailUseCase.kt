package com.ronnie.domain.useCases

import com.ronnie.domain.model.NetworkResult
import com.ronnie.domain.model.movieDetail.MovieDetailResponse
import com.ronnie.domain.repository.MoviesRepository
import javax.inject.Inject

class MovieDetailUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    suspend fun invoke(id: Int): NetworkResult<MovieDetailResponse> {
        return moviesRepository.getMovieDetails(id)
    }
}