package com.example.simplelogin.activity.splash

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.simplelogin.R.color.white
import com.example.simplelogin.activity.factory.MainViewModelFactory
import com.example.simplelogin.databinding.ActivitySplashBinding


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var viewModel: SplashViewModel
    /* var apppreference: AppPrefrence? = null*/
    private var MY_PERMISSION_REQUEST_PHONE_STATE = 1
    private val listPermissionNeeded: MutableList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel =
            ViewModelProvider(this, MainViewModelFactory(application))[SplashViewModel::class.java]
        window.statusBarColor = ContextCompat.getColor(this, white)
        binding.spView = viewModel
        allowPermission()
    }

    private fun allowPermission() {
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.INTERNET
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            listPermissionNeeded.add(Manifest.permission.INTERNET)
        } else if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            listPermissionNeeded.add(Manifest.permission.CAMERA)
        } else if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            listPermissionNeeded.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        } else {
            permissionRequest()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MY_PERMISSION_REQUEST_PHONE_STATE) {
            var count = 0
            for (i in 0..<grantResults.size) {
                if (grantResults.get(i) == 0) {
                    count++
                }
            }
            if (count != grantResults.size) {
                setobserbal()
            } else {
                permissionRequest()
            }
        }
    }

    private fun permissionRequest() {
        if (!listPermissionNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(
                this@SplashActivity,
                listPermissionNeeded.toTypedArray(),
                MY_PERMISSION_REQUEST_PHONE_STATE
            )
        } else {
            setobserbal()
        }
    }

    private fun setobserbal() {
        viewModel.success.observe(this) {
            if (it.equals("login")) {
                val intent = Intent(this@SplashActivity, SplashActivity::class.java)
                startActivity(intent)
            } else if (it.equals("signup")) {
                val intent = Intent(this@SplashActivity, SplashActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, it + "", Toast.LENGTH_LONG).show()
            }
        }
    }

}