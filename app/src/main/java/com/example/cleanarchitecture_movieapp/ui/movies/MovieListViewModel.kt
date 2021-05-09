package com.example.cleanarchitecture_movieapp.ui.movies

import dagger.hilt.android.lifecycle.HiltViewModel
import xar.mvvm.xarlib.XarViewModel
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(

) :XarViewModel(){

    fun fetchMovies(search:String){

    }
}