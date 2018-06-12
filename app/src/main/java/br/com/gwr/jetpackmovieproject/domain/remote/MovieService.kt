package br.com.gwr.jetpackmovieproject.domain.remote

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by WCisang on 12/06/2018.
 */
interface MovieService {

    @GET("movie/popular")
    fun loadMovies(): Call<MovieResponse>
}