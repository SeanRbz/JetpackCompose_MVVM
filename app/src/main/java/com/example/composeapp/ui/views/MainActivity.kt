package com.example.composeapp.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.composeapp.R
import com.example.composeapp.navigation.SetNavigationController
import com.example.composeapp.ui.views.users.ShowProfileBanner
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainActivityView()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainActivityView() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Pimpify")
                }
            )
        }
        ,
        modifier = Modifier.background(color = Color(LocalContext.current.getColor(R.color.white)) )
    ) { innerPadding ->
        SetNavigationController(innerPadding = innerPadding)
    }
}