package com.example.simplelogin.activity.utility

import java.text.SimpleDateFormat
import java.util.Date

class GlobalClass {
    companion object {
        private const val FILENAME_FORMAT = "DD-MM-YYYY"
        fun getDateTime(): String {
            val simpleDateFormat = SimpleDateFormat(FILENAME_FORMAT)
            val date = simpleDateFormat.format(Date())
            return date

        }
    }
}