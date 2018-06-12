package br.com.gwr.jetpackmovieproject.di

import dagger.Component
import javax.inject.Singleton
import android.app.Application
import br.com.gwr.jetpackmovieproject.CustomApplication
import dagger.BindsInstance
import dagger.android.AndroidInjectionModule


/**
 * Created by WCisang on 28/05/2018.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class,
        AndroidInjectionModule::class,
        ActivityBuilderModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(customApplication: CustomApplication)
}