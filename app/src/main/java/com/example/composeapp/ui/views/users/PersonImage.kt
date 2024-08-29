package com.example.composeapp.ui.views.users

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.composeapp.utils.ImageUtils
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.R
import com.example.composeapp.repository.entities.UsersData

@Composable
fun ShowUserImageCircle(user: UsersData, callback: (UsersData) -> Unit) {
    Box(modifier = Modifier
        .padding(vertical = 8.dp)
        .clickable {
            callback.invoke(user)
        }) {
        ImageUtils.showImageUrlCrop(modifier = Modifier, url = user.imageUrl?:"")
    }
}

@Composable
fun ShowProfileBanner(url: String, name: String, description: String, location: String) {
    val modifier = Modifier
        .height(300.dp)
        .background(Color(LocalContext.current.getColor(R.color.white)))
        .fillMaxWidth()
    Card(modifier = modifier, shape = RoundedCornerShape(12.dp)) {
        Box {
            ImageUtils.showImageUrl(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(), url = url)
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(start = 12.dp)
            ) {
                Text(
                    text = name.capitalize(),
                    color = Color(LocalContext.current.getColor(R.color.white)),
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = description.capitalize(),
                    color = Color(LocalContext.current.getColor(R.color.white)),
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = location.capitalize(),
                    color = Color(LocalContext.current.getColor(R.color.white)),
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShowProfileBanner(
        "https://mega-onemega.com/wp-content/uploads/2024/01/MEGASTYLE-ELISIA-PARMISANO-IN-ART-1.jpg",
        "test", "dec",
        "cebu"
    )
}