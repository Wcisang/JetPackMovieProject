package br.com.gwr.jetpackmovieproject.di

import android.app.Application
import android.arch.persistence.room.Room
import br.com.gwr.jetpackmovieproject.domain.local.DataBase
import br.com.gwr.jetpackmovieproject.domain.local.MovieDAO
import br.com.gwr.jetpackmovieproject.domain.remote.ApiConstants
import br.com.gwr.jetpackmovieproject.domain.remote.MovieRequestInterceptor
import br.com.gwr.jetpackmovieproject.domain.remote.MovieService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by WCisang on 28/05/2018.
 */
@Module(includes = arrayOf(ViewModelModule::class))
class AppModule {

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.connectTimeout(3, TimeUnit.SECONDS)
        okHttpClient.readTimeout(3, TimeUnit.SECONDS)
        okHttpClient.addInterceptor(MovieRequestInterceptor())
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient): MovieService {
        val retrofit = Retrofit.Builder()
                .baseUrl(ApiConstants.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .client(okHttpClient)
                .build()

        return retrofit.create(MovieService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideMovieDatabase(application: Application): DataBase {
        return Room.databaseBuilder(application, DataBase::class.java, "movie.db").build()
    }

    @Provides
    @Singleton
    internal fun provideMovieDao(movieDatabase: DataBase): MovieDAO {
        return movieDatabase.movieDao()
    }
}