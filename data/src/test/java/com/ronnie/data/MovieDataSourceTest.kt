package com.ronnie.data

import androidx.paging.PagingSource
import com.google.gson.Gson
import com.ronnie.data.api.MovieApi
import com.ronnie.data.datasource.MovieDataSource
import com.ronnie.domain.converters.toMovieView
import com.ronnie.domain.model.movieList.MovieResponse
import com.ronnie.domain.model.uiView.MovieView
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations.openMocks
import org.mockito.junit.MockitoJUnitRunner
import java.io.FileInputStream

@RunWith(MockitoJUnitRunner::class)
class MovieDataSourceTest {

    @Mock
    private lateinit var apiService: MovieApi
    private lateinit var pagingSource: MovieDataSource
    private lateinit var movieViewList: List<MovieView>
    private val gson = Gson()
    private lateinit var movieResponse: MovieResponse

    @Before
    fun setup() {
        openMocks(this)

        val listBytes = FileInputStream("src/main/assets/list.json").readBytes()

        movieResponse = gson.fromJson(String(listBytes), MovieResponse::class.java)
        movieViewList = movieResponse.moviesList.map { movie ->
            movie.toMovieView()
        }

        pagingSource = MovieDataSource(apiService)

    }

    @Test
    fun load_returns_page_when_success() = runBlocking {
        Mockito.`when`(apiService.getMovies(anyInt()))
            .thenReturn(movieResponse)

        assertEquals(
            pagingSource.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 20,
                    placeholdersEnabled = false
                )
            ),
            PagingSource.LoadResult.Page(
                data = movieViewList,
                prevKey = null,
                nextKey = 2
            )
        )
    }

}