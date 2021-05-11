package com.example.cleanarchitecture_movieapp.ui.movies

import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture_movieapp.domain.datasource.MovieDataSource
import com.example.cleanarchitecture_movieapp.domain.models.MovieBO
import com.example.cleanarchitecture_movieapp.domain.repository.MovieRepository
import com.example.cleanarchitecture_movieapp.ui.main.MainActivity
import com.example.cleanarchitecture_movieapp.ui.splash.SplashViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import xar.mvvm.xarlib.XarViewModel
import javax.inject.Inject
import kotlin.reflect.KClass

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val repository: MovieRepository,
    private val movieDataSource: MovieDataSource
) : XarViewModel(){

    val commandFlow = flow{
        emit(MovieListCommand.ShowLoader())
        delay(200)
        emit(MovieListCommand.PopulateMovies(movieDataSource.getMoviesFromAsset("movies.json")))
    }.flowOn(Dispatchers.IO).catch {
        val x = it;
    }

    sealed class MovieListCommand {
        class ShowLoader() : MovieListCommand()
        class PopulateMovies(val movieList:List<MovieBO>): MovieListCommand()
    }
}