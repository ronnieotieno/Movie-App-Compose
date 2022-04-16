package com.ronnie.data.api

import com.ronnie.domain.model.movieDetail.MovieDetailResponse
import com.ronnie.domain.model.movieList.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("discover/movie")
    suspend fun getMovies(
        @Query("page") page: Int? = null,
    ): MovieResponse

    @GET("movie/{id}")
    suspend fun getMovieDetail(
        @Path("id") id: Int
    ): MovieDetailResponse
}