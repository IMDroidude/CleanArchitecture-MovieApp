package com.example.cleanarchitecture_movieapp.domain.repository

import com.example.cleanarchitecture_movieapp.domain.models.MovieBO
import kotlinx.coroutines.flow.Flow

interface MovieRepository{
    fun getMovies():Flow<List<MovieBO>>
}