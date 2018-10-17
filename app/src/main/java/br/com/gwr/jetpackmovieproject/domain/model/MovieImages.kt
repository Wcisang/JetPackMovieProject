package br.com.gwr.jetpackmovieproject.domain.model

import com.google.gson.annotations.SerializedName

data class MovieImages(

        @SerializedName("aspect_ratio")
        var aspectRatio : Double,

        @SerializedName("file_path")
        var path : String,

        @SerializedName("height")
        var height : Double,

        @SerializedName("iso_639_1")
        var iso639 : String,

        @SerializedName("vote_average")
        var voteAverage : Double,

        @SerializedName("vote_count")
        var voteCount : Int,

        @SerializedName("width")
        var width : Double

)