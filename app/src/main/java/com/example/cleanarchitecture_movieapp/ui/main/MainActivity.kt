package com.example.cleanarchitecture_movieapp.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.example.cleanarchitecture_movieapp.R
import com.example.cleanarchitecture_movieapp.databinding.ActivityMainBinding
import xar.mvvm.xarlib.XarActivity

class MainActivity : XarActivity<ActivityMainBinding,MainViewModel>(R.layout.activity_main) {
    override val mViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ///setContentView(R.layout.activity_main)
    }
}