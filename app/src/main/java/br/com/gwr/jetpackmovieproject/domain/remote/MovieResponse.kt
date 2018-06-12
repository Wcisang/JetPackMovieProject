package br.com.gwr.jetpackmovieproject.domain.remote

import br.com.gwr.jetpackmovieproject.domain.model.Movie
import com.google.gson.annotations.SerializedName

/**
 * Created by WCisang on 12/06/2018.
 */
data class MovieResponse(
        val page: Int,

        @SerializedName("total_results")
        val totalResults: Int,

        @SerializedName("total_pages")
        val totalPages: Int,

        val results: List<Movie>
)