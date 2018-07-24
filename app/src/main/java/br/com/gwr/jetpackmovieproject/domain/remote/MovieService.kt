package br.com.gwr.jetpackmovieproject.domain.remote

import android.arch.lifecycle.LiveData
import br.com.gwr.jetpackmovieproject.domain.Resource
import br.com.gwr.jetpackmovieproject.domain.model.Movie
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by WCisang on 12/06/2018.
 */
interface MovieService {

    @GET("movie/popular")
    fun loadMovies(): LiveData<Resource<List<Movie>>>
}