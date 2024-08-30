package com.example.composeapp.utils

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.composeapp.R

object FontUtils {
    val salsaFamily  = FontFamily(
        Font(R.font.salsa_regular)
    )

    val montserratFamily  = FontFamily(
        Font(R.font.montserrat_bold),
        Font(R.font.montserrat_regular),
        Font(R.font.montserrat_semi_bold)
    )
}