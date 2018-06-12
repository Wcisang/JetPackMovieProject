package br.com.gwr.jetpackmovieproject.ui.activity

import android.os.Bundle
import br.com.gwr.jetpackmovieproject.R
import br.com.gwr.jetpackmovieproject.databinding.ActivityMainBinding
import br.com.gwr.jetpackmovieproject.ui.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
