package com.example.composeapp.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

object DateUtils {
    fun String.parseDate(): Calendar? {
        val formatter = SimpleDateFormat("MM/dd/yyyy HH:mm", Locale.ROOT)
        val calendar = Calendar.getInstance().apply {
            time = formatter.parse(this@parseDate)
        }
        return calendar
    }
}