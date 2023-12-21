package com.example.simplelogin.activity.utility

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log

class NetworkUtility {
    companion object {
        fun isOnline(context: Context): Boolean {
            val connetivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connetivityManager != null) {
                val capabilities =
                    connetivityManager.getNetworkCapabilities(connetivityManager.activeNetwork)
                if (capabilities!!.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities!!.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "TRANSPORT_WIFI")
                    return true
                } else if (capabilities!!.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "RANSPORT_ETHERNET")
                    return true
                }
            }
            return false
        }
    }
}