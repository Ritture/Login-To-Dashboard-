package com.example.simplelogin.activity.splash


import android.app.Application
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData


class SplashViewModel(application: Application) : AndroidViewModel(application), Observable {

    var success = MutableLiveData<String>()

    fun onLoginClick() {
        success.postValue("login")
    }

    fun onSignUpClick() {
        success.postValue("signup")
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }


}