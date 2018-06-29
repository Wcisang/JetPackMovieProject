package br.com.gwr.jetpackmovieproject.domain

import android.arch.lifecycle.LiveData
import br.com.gwr.jetpackmovieproject.domain.local.MovieDAO
import br.com.gwr.jetpackmovieproject.domain.model.Movie
import br.com.gwr.jetpackmovieproject.domain.remote.MovieService
import br.com.gwr.jetpackmovieproject.util.AppExecutors
import javax.inject.Inject

/**
 * Created by WCisang on 12/06/2018.
 */
class MovieRepository @Inject constructor(
        movieService: MovieService,
        movieDAO: MovieDAO,
        appExecutors: AppExecutors) {


    fun loadPopularMovies(): LiveData<Resource<List<Movie>>> {

    }
}