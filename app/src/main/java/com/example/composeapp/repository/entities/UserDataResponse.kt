package com.example.composeapp.repository.entities

import kotlinx.serialization.Serializable

@Serializable
data class UsersData(
    val name: String? = null,
    val description: String? = null,
    val location: String? = null,
    val imageUrl: String? = null
)


@Serializable
data class UserDataResponse(
    val list : List<UsersData>,
    override val status_code: Int
): BaseResponseEntity