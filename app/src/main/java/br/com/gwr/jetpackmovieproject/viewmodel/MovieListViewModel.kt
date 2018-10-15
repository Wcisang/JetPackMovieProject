package br.com.gwr.jetpackmovieproject.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.gwr.jetpackmovieproject.domain.MovieRepository
import br.com.gwr.jetpackmovieproject.domain.Resource
import br.com.gwr.jetpackmovieproject.domain.model.Movie
import javax.inject.Inject

/**
 * Created by WCisang on 11/06/2018.
 */
class MovieListViewModel @Inject constructor(var movieRepository: MovieRepository):  ViewModel(){

    private var popularMovies: LiveData<Resource<List<Movie>?>> = MutableLiveData()

    fun getLiveData() : LiveData<Resource<List<Movie>?>> = popularMovies

    fun loadMovies(page: Int) {
        popularMovies = movieRepository.loadPopularMovies(page)
    }

}