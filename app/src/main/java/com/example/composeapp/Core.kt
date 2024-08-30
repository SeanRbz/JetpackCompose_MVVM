package com.example.composeapp

import android.app.Application
import android.util.Log
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.google.firebase.FirebaseApp
import com.google.firebase.crashlytics.FirebaseCrashlytics
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Core : Application() {
    override fun onCreate() {
        super.onCreate()
        try {
            FirebaseApp.initializeApp(this)
            Log.d("FirebaseInit", "FirebaseApp initialized")
        } catch (e: Exception) {
            Log.e("FirebaseInit", "FirebaseApp initialization error: ${e.message}")
        }
    }

}