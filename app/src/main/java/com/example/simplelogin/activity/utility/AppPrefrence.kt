package com.example.simplelogin.activity.utility

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class AppPrefrence(private val context: Context) {
    private var prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
}