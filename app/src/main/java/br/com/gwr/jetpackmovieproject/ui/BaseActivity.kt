package br.com.gwr.jetpackmovieproject.ui

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by WCisang on 29/05/2018.
 */
abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentAndroidInjector: DispatchingAndroidInjector<Fragment>

    lateinit var dataBinding: DB

    @get:LayoutRes
    abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, layoutRes)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentAndroidInjector
    }
}