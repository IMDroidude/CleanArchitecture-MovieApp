package com.example.cleanarchitecture_movieapp.di

import com.example.cleanarchitecture_movieapp.domain.prefs.MoviePrefs
import com.example.cleanarchitecture_movieapp.domain.prefs.MoviePrefsImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xar.mvvm.xarlib.prefs.PrefStore
import xar.mvvm.xarlib.prefs.SharedPrefStore

@Module
@InstallIn(SingletonComponent::class)
abstract class UtilityModule {

    @Binds
    abstract fun bindPrefStore(sharedPrefStore: SharedPrefStore): PrefStore

    @Binds
    abstract fun bindmoviePrefs(moviePrefsImpl: MoviePrefsImpl): MoviePrefs

}