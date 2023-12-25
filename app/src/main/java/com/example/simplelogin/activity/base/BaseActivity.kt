package com.example.simplelogin.activity.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.simplelogin.activity.factory.MainViewModelFactory
import com.example.simplelogin.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {
    lateinit var binding: ActivityBaseBinding
    lateinit var viewModel: BaseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityBaseBinding.inflate(layoutInflater).root)
        viewModel = ViewModelProvider(this, MainViewModelFactory(application))[BaseViewModel::class.java]
    }
}