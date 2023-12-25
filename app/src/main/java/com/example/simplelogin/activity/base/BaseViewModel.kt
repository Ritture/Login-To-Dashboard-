package com.example.simplelogin.activity.base

import android.app.Application
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel


class BaseViewModel(application: Application) : AndroidViewModel(application), Observable {


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }
}