package com.example.simplelogin.activity.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.simplelogin.activity.factory.MainViewModelFactory
import com.example.simplelogin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding :ActivityLoginBinding
    lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityLoginBinding.inflate(layoutInflater).root)
        viewModel = ViewModelProvider(this, MainViewModelFactory(application))[LoginViewModel::class.java]

    }
}