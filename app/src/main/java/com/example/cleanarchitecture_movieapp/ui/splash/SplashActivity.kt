package com.example.cleanarchitecture_movieapp.ui.splash

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecture_movieapp.R
import com.example.cleanarchitecture_movieapp.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import xar.mvvm.xarlib.XarActivity
import xar.mvvm.xarlib.extensions.launchActivity
import xar.mvvm.xarlib.extensions.toast

@AndroidEntryPoint
class SplashActivity :
    XarActivity<ActivitySplashBinding, SplashViewModel>(R.layout.activity_splash) {
    override val mViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.mViewModel = this.mViewModel

        //flow handle back-pressure. It is far better than live-data except handling lifecycle
        // which will be supported in upcoming version
        lifecycleScope.launchWhenStarted {
            mViewModel.commandFlow.collect {
                when (it) {
                    is SplashViewModel.SplashCommand.OpenNextScreen -> launchActivity(it.className.java)
                    is SplashViewModel.SplashCommand.WelcomeTitle -> mBinding.welcomeTv.text(it.title)//toast(it.title)
                }
            }
        }
    }
}