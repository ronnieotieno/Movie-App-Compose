package com.ronnie.data.di

import com.ronnie.data.repository.MovieRepositoryImpl
import com.ronnie.domain.repository.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun providesRepository(repositoryImpl: MovieRepositoryImpl): MoviesRepository
}