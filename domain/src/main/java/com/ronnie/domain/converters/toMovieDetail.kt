package com.ronnie.domain.converters

import com.ronnie.commons.IMAGE_URL
import com.ronnie.domain.model.movieDetail.MovieDetailResponse
import com.ronnie.domain.model.uiView.MovieDetail

fun MovieDetailResponse.toMovieDetail() = MovieDetail(
    title = title,
    release_date = release_date?.substringBefore("-") ?: "",
    vote = vote_average.toString(),
    image = IMAGE_URL + poster_path,
    overView = overview,
    genres = genres
)