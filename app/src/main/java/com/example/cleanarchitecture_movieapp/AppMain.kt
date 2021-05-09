package com.example.cleanarchitecture_movieapp

import dagger.hilt.android.HiltAndroidApp
import xar.mvvm.xarlib.XarApplication


@HiltAndroidApp
class AppMain : XarApplication(){

    override fun onCreate() {
        super.onCreate()
    }
}