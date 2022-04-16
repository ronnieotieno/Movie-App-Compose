package com.ronnie.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.ronnie.domain.useCases.MovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val movieListUseCase: MovieListUseCase) :
    ViewModel() {
    val movieList get() = getMovies()
     private fun getMovies() = movieListUseCase.invoke()
}