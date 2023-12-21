package com.example.simplelogin.activity.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.simplelogin.activity.MainViewModelFactory
import com.example.simplelogin.activity.utility.AppPrefrence
import com.example.simplelogin.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var viewModel: SplashViewModel
    var apppreference: AppPrefrence? = null
    var MY_PERMISSION_REQUEST_PHONE_STATE = 1
    val listPermissionNeeded: MutableList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel =
            ViewModelProvider(this, MainViewModelFactory(application))[SplashViewModel::class.java]
        binding.spView = viewModel
        allowPermission()
    }

    private fun allowPermission() {
       // if(ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)!=PackageManager.PERMISSION_GRANTED)
    }

}