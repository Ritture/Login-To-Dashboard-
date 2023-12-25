package com.example.simplelogin.activity.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simplelogin.activity.base.BaseViewModel
import com.example.simplelogin.activity.splash.SplashViewModel

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private var application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            SplashViewModel(application) as T
        } else if (modelClass.isAssignableFrom(BaseViewModel::class.java)) {
            BaseViewModel(application) as T
        } else {
            throw IllegalArgumentException("Unknown View Model Class")
        }
    }
}
