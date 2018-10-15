package br.com.gwr.jetpackmovieproject.domain.remote

import android.arch.lifecycle.LiveData
import br.com.gwr.jetpackmovieproject.domain.Resource
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by WCisang on 12/06/2018.
 */
interface MovieService {

    @GET("movie/popular")
    fun loadMovies(@Query("page") page: Int): LiveData<Resource<MovieResponse>>
}