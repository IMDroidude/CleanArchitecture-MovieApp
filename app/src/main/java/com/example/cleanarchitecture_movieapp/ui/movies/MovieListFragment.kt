package com.example.cleanarchitecture_movieapp.ui.movies

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecture_movieapp.R
import com.example.cleanarchitecture_movieapp.databinding.FragmentMovieListBinding
import com.example.cleanarchitecture_movieapp.domain.models.MovieBO
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import xar.mvvm.xarlib.XarFragment

@AndroidEntryPoint
class MovieListFragment :
    XarFragment<FragmentMovieListBinding, MovieListViewModel>(R.layout.fragment_movie_list) {
    override val mViewModel: MovieListViewModel by viewModels()
    private var movieList: MutableList<MovieBO> = ArrayList<MovieBO>()
    lateinit var movieAdapter: MoviesAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieAdapter = MoviesAdapter(movieList) { position, movieClicked ->
            // FIXME: 5/11/2021 open MovieDetail page 
        }
        mBinding.recyclerView.apply {
            ///layoutManager = LinearLayoutManager(context)
            hasFixedSize()
            adapter = movieAdapter
        }

        lifecycleScope.launchWhenStarted {
            mViewModel.commandFlow.collect {
                when (it) {
                    is MovieListViewModel.MovieListCommand.ShowLoader -> {
                    }
                    is MovieListViewModel.MovieListCommand.PopulateMovies -> {
                        movieAdapter.setItems(it.movieList.toMutableList())
                    }
                }
            }
        }
    }


}