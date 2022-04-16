package com.ronnie.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ronnie.data.api.MovieApi
import com.ronnie.data.datasource.MovieDataSource
import com.ronnie.domain.model.NetworkResult
import com.ronnie.domain.model.movieDetail.MovieDetailResponse
import com.ronnie.domain.model.movieList.Movie
import com.ronnie.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api:MovieApi): MoviesRepository, BaseRepository() {
    override fun getMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 25),
            pagingSourceFactory = {
               MovieDataSource(api)
            }
        ).flow
    }

    override suspend fun getMovieDetails(id: Int): NetworkResult<MovieDetailResponse> {
        return safeApiCall { api.getMovieDetail(id) }
    }
}