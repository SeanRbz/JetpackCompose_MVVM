package com.example.composeapp.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.constants.Constants
import com.example.composeapp.R
import com.example.composeapp.navigation.SetNavigationController
import com.example.composeapp.ui.views.base.HeadLineText
import com.example.composeapp.ui.views.nearbyUsers.ShowProfileBanner
import com.example.composeapp.utils.FontUtils
import com.example.composeapp.utils.ImageUtils
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
    val context = LocalContext.current
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    HeadLineText(
                        text = "Pimpify", fontSize = 24.sp,
                        fontFamily = FontUtils.salsaFamily
                    )
                }
            )
        },
        bottomBar = {
            NavigationBar {
                Constants.NavBottomList.forEach { item ->
                    NavigationBarItem(
                        selected = false,
                        onClick = {},
                        label = {
                            Text(text = item.title)
                        },
                        alwaysShowLabel = false,
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.badgeCount > 0) {
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    }
                                }
                            ) {
                                ImageUtils.showImageDrawableWithText(
                                    drawable = item.icon,
                                    text = item.title,
                                    colorFilter =
                                    if(navController.currentDestination?.route == item.nav.route) {
                                        ColorFilter.tint(color = Color(context.getColor(R.color.theme_color)))
                                    }else null
                                )
                            }
                        }
                    )
                }
            }
        },
        modifier = Modifier.background(color = Color(LocalContext.current.getColor(R.color.white)))
    ) { innerPadding ->
        SetNavigationController(innerPadding = innerPadding, navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    ShowProfileBanner(
        url = "https://mega-onemega.com/wp-content/uploads/2024/01/MEGASTYLE-ELISIA-PARMISANO-IN-ART-1.jpg",
        name = "",
        description = "",
        location = "",
    )
}
