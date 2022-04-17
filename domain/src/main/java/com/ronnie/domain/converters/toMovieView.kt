package com.ronnie.domain.converters

import com.ronnie.commons.IMAGE_URL
import com.ronnie.domain.model.movieList.Movie
import com.ronnie.domain.model.uiView.MovieView

fun Movie.toMovieView() = MovieView(
    title = title,
    id = id,
    release_date = release_date?.substringBefore("-") ?: "",
    vote = vote_average.toString(),
    image = IMAGE_URL + poster_path
)