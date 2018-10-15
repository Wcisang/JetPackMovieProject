package br.com.gwr.jetpackmovieproject.domain

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import br.com.gwr.jetpackmovieproject.domain.local.MovieDAO
import br.com.gwr.jetpackmovieproject.domain.model.Movie
import br.com.gwr.jetpackmovieproject.domain.remote.MovieResponse
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


    fun loadPopularMovies(page: Int): LiveData<Resource<List<Movie>?>> {
        return object : NetworkBoundResource<List<Movie>, MovieResponse>(appExecutors) {
            override fun saveCallResult(item: MovieResponse) = movieDAO.saveMovies(item.results)

            override fun shouldFetch(data: List<Movie>?) = true

            override fun loadFromDb(): LiveData<List<Movie>> {
                var high = (20 * page) - 20
                var low = 20
                return movieDAO.loadPopularMovies(low, high)
            }

            override fun createCall() = movieService.loadMovies(page)

        }.asLiveData()
    }
}