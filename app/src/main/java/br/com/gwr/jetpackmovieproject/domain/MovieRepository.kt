package br.com.gwr.jetpackmovieproject.domain

import android.arch.lifecycle.LiveData
import br.com.gwr.jetpackmovieproject.domain.local.MovieDAO
import br.com.gwr.jetpackmovieproject.domain.model.Movie
import br.com.gwr.jetpackmovieproject.domain.remote.MovieService
import br.com.gwr.jetpackmovieproject.domain.remote.NetworkBoundResource
import br.com.gwr.jetpackmovieproject.util.AppExecutors
import javax.inject.Inject

/**
 * Created by WCisang on 12/06/2018.
 */
class MovieRepository @Inject constructor(
        val movieService: MovieService,
        val movieDAO: MovieDAO,
        val appExecutors: AppExecutors) {


    fun loadPopularMovies(): LiveData<Resource<List<Movie>?>> {
        return object : NetworkBoundResource<List<Movie>, List<Movie>>(appExecutors) {
            override fun saveCallResult(item: List<Movie>) {
                movieDAO.saveMovies(item)
            }

            override fun shouldFetch(data: List<Movie>?) = true

            override fun loadFromDb() = movieDAO.loadMovies()

            override fun createCall() = movieService.loadMovies()

        }.asLiveData()
    }
}