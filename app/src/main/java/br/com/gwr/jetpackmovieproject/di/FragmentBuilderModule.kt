package br.com.gwr.jetpackmovieproject.di

import br.com.gwr.jetpackmovieproject.ui.fragment.MovieDetailFragment
import br.com.gwr.jetpackmovieproject.ui.fragment.MovieListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by WCisang on 11/06/2018.
 */
@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeMovieListFragment(): MovieListFragment

    @ContributesAndroidInjector
    abstract fun contributeMovieDetailFragment(): MovieDetailFragment
}