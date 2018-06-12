package br.com.gwr.jetpackmovieproject

import android.app.Activity
import android.app.Application
import br.com.gwr.jetpackmovieproject.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by WCisang on 28/05/2018.
 */
class CustomApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingInjector
    }
}