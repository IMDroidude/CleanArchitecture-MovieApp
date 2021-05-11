package com.example.cleanarchitecture_movieapp.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.example.cleanarchitecture_movieapp.R
import com.example.cleanarchitecture_movieapp.databinding.ActivityMainBinding
import com.example.cleanarchitecture_movieapp.domain.models.MovieBO
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONArray
import org.json.JSONObject
import xar.mvvm.xarlib.XarActivity
import xar.mvvm.xarlib.extensions.readFile

@AndroidEntryPoint
class MainActivity : XarActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {
    override val mViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ///setContentView(R.layout.activity_main)

        val jsonString = this.assets.readFile("movies.json");

    }
}