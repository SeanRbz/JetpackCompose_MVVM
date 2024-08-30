package com.example.composeapp.repository.entities

import androidx.annotation.Keep
import kotlinx.serialization.Serializable


@Keep
interface BaseResponseEntity {
    val status_code: Int
}