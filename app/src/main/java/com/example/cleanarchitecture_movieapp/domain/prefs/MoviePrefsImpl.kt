package com.example.cleanarchitecture_movieapp.domain.prefs

import xar.mvvm.xarlib.prefs.PrefStore
import javax.inject.Inject

class MoviePrefsImpl @Inject constructor(private val prefStore: PrefStore):MoviePrefs{

}