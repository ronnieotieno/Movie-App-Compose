package com.ronnie.domain.useCases

import androidx.paging.PagingData
import com.ronnie.domain.model.uiView.MovieView
import com.ronnie.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieListUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    fun invoke(): Flow<PagingData<MovieView>> {
        return moviesRepository.getMovies()
    }
}