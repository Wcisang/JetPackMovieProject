package br.com.gwr.jetpackmovieproject.di

import br.com.gwr.jetpackmovieproject.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by WCisang on 28/05/2018.
 */
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(FragmentBuilderModule::class))
    abstract fun mainActivity(): MainActivity

}