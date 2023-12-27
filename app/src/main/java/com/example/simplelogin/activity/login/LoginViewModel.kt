package com.example.simplelogin.activity.login

import android.app.Application
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel

class LoginViewModel(application: Application): AndroidViewModel(application), Observable {
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}