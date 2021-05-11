package com.example.cleanarchitecture_movieapp.ui.movi_details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.cleanarchitecture_movieapp.R
import com.example.cleanarchitecture_movieapp.databinding.FragmentMovieDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import xar.mvvm.xarlib.XarFragment

@AndroidEntryPoint
class MovieDetailFragment : XarFragment<FragmentMovieDetailBinding,MovieDetailViewModel>(R.layout.fragment_movie_detail) {
    //val mViewModel: MovieDetailViewModel by hiltNavGraphViewModels(R.id.detail)
    override val mViewModel: MovieDetailViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}