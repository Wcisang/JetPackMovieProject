package br.com.gwr.jetpackmovieproject.ui.fragment

import android.arch.lifecycle.Observer
import android.graphics.Movie
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import br.com.gwr.jetpackmovieproject.R
import br.com.gwr.jetpackmovieproject.databinding.FragmentMovieListBinding
import br.com.gwr.jetpackmovieproject.ui.BaseFragment
import br.com.gwr.jetpackmovieproject.ui.adapter.MovieAdapter
import br.com.gwr.jetpackmovieproject.util.EndlessRecyclerViewScrollListener
import br.com.gwr.jetpackmovieproject.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.fragment_movie_list.*

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
        setupRecyclerView()
        loadMovies(1)
    }

    private fun setupRecyclerView() {
        rvMovies.layoutManager = LinearLayoutManager(activity)
        rvMovies.addOnScrollListener(object : EndlessRecyclerViewScrollListener() {
            override fun onLoadMore(page: Int) {
                loadMovies(page)
            }
        })
        val adapter = MovieAdapter()
        rvMovies.adapter = adapter
    }

    private fun loadMovies(page: Int) {
        viewModel.loadMovies(page)
        viewModel.getLiveData().observe(this, Observer {
            if (it?.data != null)
                (rvMovies.adapter as MovieAdapter).addAll(it.data!!)
        })
    }

}