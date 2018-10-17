package br.com.gwr.jetpackmovieproject.domain.remote

import br.com.gwr.jetpackmovieproject.domain.model.MovieImages

data class MovieImageResponse(
        var id: Int,
        var backdrops: List<MovieImages>,
        var posters: List<MovieImages>
)