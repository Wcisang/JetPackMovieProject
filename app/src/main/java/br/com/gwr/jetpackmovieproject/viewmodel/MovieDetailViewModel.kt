package br.com.gwr.jetpackmovieproject.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.gwr.jetpackmovieproject.domain.MovieRepository
import br.com.gwr.jetpackmovieproject.domain.Resource
import br.com.gwr.jetpackmovieproject.domain.remote.MovieImageResponse
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(var movieRepository: MovieRepository): ViewModel() {

    var imagesLiveData : LiveData<Resource<MovieImageResponse?>> = MutableLiveData()

    fun loadImages(id: Int) {
        imagesLiveData = movieRepository.loadImagesFromMovie(id)
    }

}