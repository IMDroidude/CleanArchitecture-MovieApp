package com.example.cleanarchitecture_movieapp.ui.splash

import com.example.cleanarchitecture_movieapp.ui.main.MainActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import xar.mvvm.xarlib.XarViewModel
import javax.inject.Inject
import kotlin.reflect.KClass

@HiltViewModel
class SplashViewModel @Inject constructor(

): XarViewModel(){

    val commandFlow = flow{
        emit(SplashCommand.WelcomeTitle("Welcome"))
        delay(1200)
        emit(SplashCommand.OpenNextScreen(MainActivity::class))
    }

    //using sealed class for clean architecture and passing any type of command along with data
    sealed class SplashCommand {
        class OpenNextScreen(val className: KClass<*>) : SplashCommand()
        class WelcomeTitle(val title:String):SplashCommand()
    }
}