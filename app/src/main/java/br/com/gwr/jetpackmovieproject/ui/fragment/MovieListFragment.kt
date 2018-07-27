package br.com.gwr.jetpackmovieproject.ui.fragment

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.util.Log
import br.com.gwr.jetpackmovieproject.R
import br.com.gwr.jetpackmovieproject.databinding.FragmentMovieListBinding
import br.com.gwr.jetpackmovieproject.ui.BaseFragment
import br.com.gwr.jetpackmovieproject.viewmodel.MovieListViewModel

/**
 * Created by WCisang on 11/06/2018.
 */
class MovieListFragment : BaseFragment<MovieListViewModel, FragmentMovieListBinding>() {

    override fun getViewModel(): Class<MovieListViewModel> {
        return MovieListViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_movie_list
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getLiveData().observe(this, Observer { Log.i("WILLTAG", it.toString()) })
    }

}