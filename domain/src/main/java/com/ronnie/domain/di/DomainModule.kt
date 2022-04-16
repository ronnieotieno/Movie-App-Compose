package com.ronnie.domain.di

import com.ronnie.domain.repository.MoviesRepository
import com.ronnie.domain.useCases.MovieDetailUseCase
import com.ronnie.domain.useCases.MovieListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideListUseCase(moviesRepository: MoviesRepository) =
        MovieListUseCase(moviesRepository)

    @Provides
    @Singleton
    fun provideDetailUseCase(moviesRepository: MoviesRepository) =
        MovieDetailUseCase(moviesRepository)
}