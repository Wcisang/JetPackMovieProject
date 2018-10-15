package br.com.gwr.jetpackmovieproject.domain.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import br.com.gwr.jetpackmovieproject.domain.model.Movie

/**
 * Created by WCisang on 12/06/2018.
 */

@Dao
interface MovieDAO {

    @Query("SELECT * FROM movies ORDER BY popularity DESC LIMIT :low OFFSET :high")
    fun loadPopularMovies(low: Int, high: Int) : LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovies(movies: List<Movie>)
}