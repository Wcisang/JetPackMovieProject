package br.com.gwr.jetpackmovieproject.ui

import android.os.Bundle
import br.com.gwr.jetpackmovieproject.R
import br.com.gwr.jetpackmovieproject.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
