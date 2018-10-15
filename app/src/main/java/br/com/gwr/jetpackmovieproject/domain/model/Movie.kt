package br.com.gwr.jetpackmovieproject.domain.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by WCisang on 12/06/2018.
 */
@Entity(tableName = "movies")
data class Movie(

        @PrimaryKey
        @SerializedName("id")
        val id: Int,

        @SerializedName("title")
        val title: String,

        @SerializedName("original_title")
        val originalTitle: String?,

        @SerializedName("poster_path")
        val posterPath: String?,

        @SerializedName("adult")
        val adult: Boolean?,

        @SerializedName("overview")
        val overview: String?,

        @SerializedName("vote_count")
        val voteCount: Int?,

        @SerializedName("vote_average")
        val voteAverage: Double?,

        @SerializedName("backdrop_path")
        val backdropPath: String?,

        @SerializedName("original_language")
        val originalLanguage: String?,

        @SerializedName("popularity")
        val popularity: Double?
) : Serializable