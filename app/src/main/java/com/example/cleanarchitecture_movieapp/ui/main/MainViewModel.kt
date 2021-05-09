package com.example.cleanarchitecture_movieapp.ui.main

import dagger.hilt.android.lifecycle.HiltViewModel
import xar.mvvm.xarlib.XarViewModel
import xar.mvvm.xarlib.prefs.PrefStore
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val prefStore: PrefStore
): XarViewModel(){

    init {
        if(prefStore.getBoolean("anyTestKey",false)){

        }
    }
}