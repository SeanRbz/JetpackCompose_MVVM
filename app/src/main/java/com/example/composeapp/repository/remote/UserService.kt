package com.example.composeapp.repository.remote

import com.example.composeapp.repository.entities.BaseResponseEntity
import com.example.composeapp.repository.entities.UserDataResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserService {

    @Headers("Content-Type: application/json")
    @POST("/userList")
    suspend fun getNearbyUsers(): UserDataResponse
}