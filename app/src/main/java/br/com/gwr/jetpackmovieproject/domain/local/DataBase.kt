package br.com.gwr.jetpackmovieproject.domain.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.gwr.jetpackmovieproject.domain.model.Movie

/**
 * Created by WCisang on 12/06/2018.
 */
@Database(entities = arrayOf(Movie::class), version = 1)
abstract class DataBase : RoomDatabase() {

    abstract fun movieDao(): MovieDAO
}