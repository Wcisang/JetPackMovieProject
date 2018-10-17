package br.com.gwr.jetpackmovieproject.ui.activity

import android.os.Bundle
import br.com.gwr.jetpackmovieproject.R
import br.com.gwr.jetpackmovieproject.databinding.ActivityMainBinding
import br.com.gwr.jetpackmovieproject.domain.model.Movie
import br.com.gwr.jetpackmovieproject.ui.BaseActivity
import br.com.gwr.jetpackmovieproject.ui.fragment.MovieDetailFragment
import br.com.gwr.jetpackmovieproject.ui.fragment.MovieListFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
                .add(R.id.listMovieFrag, MovieListFragment())
                .commit()
    }

    fun showDetail(movie: Movie) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.listMovieFrag, MovieDetailFragment.newInstance(movie))
                .addToBackStack(null)
                .commit()
    }
}
