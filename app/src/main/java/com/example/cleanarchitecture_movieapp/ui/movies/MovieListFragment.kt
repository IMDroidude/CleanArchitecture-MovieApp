package com.example.cleanarchitecture_movieapp.ui.movies

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.cleanarchitecture_movieapp.R
import com.example.cleanarchitecture_movieapp.databinding.FragmentMovieListBinding
import xar.mvvm.xarlib.XarFragment

class MovieListFragment : XarFragment<FragmentMovieListBinding,MovieListViewModel>(R.layout.fragment_movie_list) {
    override val mViewModel: MovieListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}