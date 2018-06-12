package br.com.gwr.jetpackmovieproject.domain

import br.com.gwr.jetpackmovieproject.domain.local.MovieDAO
import br.com.gwr.jetpackmovieproject.domain.remote.MovieService
import javax.inject.Inject

/**
 * Created by WCisang on 12/06/2018.
 */
class MovieRepository @Inject constructor(movieService: MovieService, movieDAO: MovieDAO) {


}