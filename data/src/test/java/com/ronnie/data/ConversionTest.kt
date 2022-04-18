package com.ronnie.data

import com.google.gson.Gson
import com.ronnie.domain.converters.toMovieDetail
import com.ronnie.domain.converters.toMovieView
import com.ronnie.domain.model.movieDetail.Genre
import com.ronnie.domain.model.movieDetail.MovieDetailResponse
import com.ronnie.domain.model.movieList.Movie
import com.ronnie.domain.model.movieList.MovieResponse
import com.ronnie.domain.model.uiView.MovieDetail
import com.ronnie.domain.model.uiView.MovieView
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations.openMocks
import org.mockito.junit.MockitoJUnitRunner
import java.io.FileInputStream

@RunWith(MockitoJUnitRunner::class)
class ConversionTest {

    private val gson = Gson()
    private lateinit var movieDetailResponse: MovieDetailResponse
    private lateinit var movie: Movie

    @Before
    fun setup() {
        openMocks(this)

        val detailBytes = FileInputStream("src/main/assets/detail.json").readBytes()
        val listBytes = FileInputStream("src/main/assets/list.json").readBytes()

        movieDetailResponse = gson.fromJson(String(detailBytes), MovieDetailResponse::class.java)
        movie = gson.fromJson(String(listBytes), MovieResponse::class.java).moviesList[0]

    }

    @Test
    fun test_detail_conversion_should_pass() {
        val movieDetail = movieDetailResponse.toMovieDetail()
        val expectedMovieDetail = MovieDetail(
            title = "Sonic the Hedgehog 2",
            release_date = "2022",
            vote = "7.7",
            image = "https://image.tmdb.org/t/p/w500/6DrHO1jr3qVrViUO6s6kFiAGM7.jpg",
            overView = "After settling in Green Hills, Sonic is eager to prove he has what it takes to be a true hero. His test comes when Dr. Robotnik returns, this time with a new partner, Knuckles, in search for an emerald that has the power to destroy civilizations. Sonic teams up with his own sidekick, Tails, and together they embark on a globe-trotting journey to find the emerald before it falls into the wrong hands.",
            genres = listOf(
                Genre(28, "Action"),
                Genre(878, "Science Fiction"),
                Genre(35, "Comedy"),
                Genre(10751, "Family")
            )
        )
        assertEquals(expectedMovieDetail, movieDetail)
    }

    @Test
    fun test_list_conversion_should_pass() {
        val movieView = movie.toMovieView()
        val expectedMovieView = MovieView(
            id = 634649,
            title = "Spider-Man: No Way Home",
            release_date = "2021",
            vote = "8.2",
            image = "https://image.tmdb.org/t/p/w500/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
        )
        assertEquals(expectedMovieView, movieView)
    }
}