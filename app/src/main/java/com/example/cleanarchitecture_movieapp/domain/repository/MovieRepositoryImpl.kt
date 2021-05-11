package com.example.cleanarchitecture_movieapp.domain.repository

import android.content.Context
import com.example.cleanarchitecture_movieapp.domain.datasource.MovieDataSource
import com.example.cleanarchitecture_movieapp.domain.models.MovieBO
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    @ApplicationContext val mContext: Context,
    private val movieDataSource: MovieDataSource
) : MovieRepository {
    override fun getMovies(): Flow<List<MovieBO>> = flow {
        emit(movieDataSource.getMoviesFromAsset("movies.json"))
    }.flowOn(Dispatchers.IO)
}
