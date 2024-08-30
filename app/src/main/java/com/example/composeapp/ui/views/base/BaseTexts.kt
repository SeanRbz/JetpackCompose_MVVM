package com.example.composeapp.ui.views.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.composeapp.R
import com.example.composeapp.utils.FontUtils


@Composable
fun BaseInputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String? = null
) {
    Column(modifier) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            placeholder = placeholder?.let { { Text(it) } },
            modifier = Modifier.fillMaxWidth().background(Color(LocalContext.current.getColor(R.color.light_gray))),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            )
        )
    }
}

@Composable
fun BaseNormalText(modifier: Modifier = Modifier,text:String,textAlign: TextAlign = TextAlign.Start,
                   textColor: Color = Color.White , fontWeight: FontWeight = FontWeight.Light){
    Text(
        fontFamily = FontUtils.montserratFamily,
        fontWeight = fontWeight,
        text = text,
        color = textColor,
        textAlign = textAlign,
        fontSize = 12.sp,
        modifier = modifier
    )
}


@Composable
fun HeadLineText(modifier: Modifier = Modifier,text: String,fontSize: TextUnit,fontFamily : FontFamily = FontUtils.montserratFamily) {
    BaseBoldText(text = text, modifier = modifier, textColor = Color.Black,fontSize = fontSize,
        fontFamily = fontFamily )
}


@Composable
fun BaseBoldText(modifier: Modifier = Modifier,text:String,
                 textAlign: TextAlign = TextAlign.Start,
                 textColor: Color = Color.White, fontSize : TextUnit = 16.sp,
                 fontFamily: FontFamily = FontUtils.montserratFamily
){
    Text(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        text = text,
        color = textColor,
        textAlign = textAlign,
        fontSize = fontSize,
        modifier = modifier
    )
}