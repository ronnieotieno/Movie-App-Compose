package com.ronnie.domain.useCases

import androidx.paging.PagingData
import com.ronnie.domain.model.movieList.Movie
import com.ronnie.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieListUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    fun invoke(): Flow<PagingData<Movie>> {
        return moviesRepository.getMovies()
    }
}