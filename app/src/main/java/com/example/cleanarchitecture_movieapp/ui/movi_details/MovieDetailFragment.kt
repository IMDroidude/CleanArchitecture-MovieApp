package com.example.cleanarchitecture_movieapp.ui.movi_details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.cleanarchitecture_movieapp.R
import com.example.cleanarchitecture_movieapp.databinding.FragmentMovieDetailBinding
import xar.mvvm.xarlib.XarFragment


class MovieDetailFragment : XarFragment<FragmentMovieDetailBinding, MovieDetailViewModel>(R.layout.fragment_movie_detail) {
    override val mViewModel: MovieDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}