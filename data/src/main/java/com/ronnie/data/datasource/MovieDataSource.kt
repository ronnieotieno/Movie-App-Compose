package com.ronnie.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ronnie.commons.FIRST_PAGE
import com.ronnie.data.api.MovieApi
import com.ronnie.domain.model.movieList.Movie
import java.io.IOException

/**
 * Paging 3 data source to query the pages based on scroll state
 */
class MovieDataSource(
    private val api: MovieApi,
) :
    PagingSource<Int, Movie>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: FIRST_PAGE
        return try {
            val data = api.getMovies(page)
            LoadResult.Page(
                data = data.moviesList,
                prevKey = if (page == FIRST_PAGE) null else page - 1,
                nextKey = if (page > 500) null else page + 1
            )
        } catch (t: Throwable) {
            var exception = t
            if (t is IOException) {
                exception = IOException("Please check your internet connection and try again")
            }
            LoadResult.Error(exception)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }
}