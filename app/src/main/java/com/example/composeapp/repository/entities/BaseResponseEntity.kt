package com.example.composeapp.repository.entities

import kotlinx.serialization.Serializable


interface BaseResponseEntity {
    val status_code: Int
}