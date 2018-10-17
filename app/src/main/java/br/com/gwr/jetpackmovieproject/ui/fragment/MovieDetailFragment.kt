package br.com.gwr.jetpackmovieproject.ui.fragment

import android.os.Bundle
import android.view.View
import br.com.gwr.jetpackmovieproject.R
import br.com.gwr.jetpackmovieproject.databinding.FragmentMovieDetailBinding
import br.com.gwr.jetpackmovieproject.domain.model.Movie
import br.com.gwr.jetpackmovieproject.ui.BaseFragment
import br.com.gwr.jetpackmovieproject.viewmodel.MovieDetailViewModel


class MovieDetailFragment : BaseFragment<MovieDetailViewModel, FragmentMovieDetailBinding>() {

    override fun getViewModel(): Class<MovieDetailViewModel> = MovieDetailViewModel::class.java

    override fun getLayoutRes(): Int = R.layout.fragment_movie_detail

    companion object {
        fun newInstance(movie: Movie) : MovieDetailFragment {
            val bundle = Bundle ()
            bundle.putSerializable("movie", movie)
            val fragment = MovieDetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie = arguments?.getSerializable("movie") as Movie
        dataBinding.movie = movie
    }
}
