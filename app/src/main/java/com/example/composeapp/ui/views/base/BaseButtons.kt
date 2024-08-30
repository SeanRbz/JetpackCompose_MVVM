package com.example.composeapp.ui.views.base

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BaseButton(modifier: Modifier =Modifier, onclick: () -> Unit, text: String, backgroundColor: Color) {
    Button(modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = Color.White,// Color of the button content
        ), shape = RoundedCornerShape(12), onClick = { onclick.invoke() }) {
        BaseNormalText(text = text)
    }
}

@Composable
fun BaseCheckbox(onCheckedChange: () -> Unit) {
    Checkbox(modifier = Modifier.padding(0.dp), checked = false, onCheckedChange = {onCheckedChange.invoke()})
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BaseInputField(label = "example@email.com", value = "",{})
}