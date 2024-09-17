package com.example.composeapp.ui.views.nearbyUsers

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.composeapp.utils.ImageUtils
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.R
import com.example.composeapp.repository.entities.UsersData
import com.example.composeapp.ui.views.base.BaseBoldText
import com.example.composeapp.ui.views.base.BaseNormalText

@Composable
fun ShowUserImageCircle(user: UsersData, callback: (UsersData) -> Unit) {
    val color = Color(LocalContext.current.getColor(R.color.theme_color))
    ImageUtils.showImageUrlCrop(
        modifier = Modifier
            .border(2.dp, color, RoundedCornerShape(50.dp))
            .height(64.dp)
            .width(64.dp)
            .clickable { callback.invoke(user) },
        url = user.imageUrl ?: ""
    )
}

@Composable
fun ShowProfileBanner(url: String, name: String, description: String, location: String) {
    val context = LocalContext.current

    val textBoxModifier = Modifier
        .padding(horizontal = 12.dp)
        .background(Color(context.getColor(R.color.light_gray_2)))

    val cardModifier = Modifier
        .fillMaxHeight()
        .background(Color(context.getColor(R.color.white)))
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 16.dp)

    Card(modifier = cardModifier, shape = RoundedCornerShape(12.dp)) {
        Box {
            ImageUtils.showImageUrl(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(), url = url
            )
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .alpha(.30f)
            ) {
                Box(modifier = textBoxModifier) {
                    BaseBoldText(
                        modifier = Modifier.wrapContentWidth(),
                        text = name.capitalize(), textColor = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Box(modifier = textBoxModifier) {
                    BaseNormalText(
                        modifier = Modifier.wrapContentWidth(),
                        text = description.capitalize(), textColor = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Box(modifier = textBoxModifier) {
                    BaseNormalText(
                        modifier = Modifier.wrapContentWidth(),
                        text = location.capitalize(), textColor = Color.White
                    )
                }
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