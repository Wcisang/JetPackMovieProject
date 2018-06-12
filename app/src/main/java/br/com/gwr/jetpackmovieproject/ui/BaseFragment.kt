package br.com.gwr.jetpackmovieproject.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Created by WCisang on 11/06/2018.
 */
abstract class BaseFragment<VM : ViewModel, DB : ViewDataBinding> : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM

    lateinit var dataBinding: DB

    abstract fun getViewModel(): Class<VM>

    @LayoutRes
    abstract fun getLayoutRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        return dataBinding.root
    }
}