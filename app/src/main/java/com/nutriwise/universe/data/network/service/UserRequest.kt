package com.nutriwise.universe.data.network.service

import com.google.gson.annotations.SerializedName
import retrofit2.http.Part

data class UserRegister(
    @Part("name")
    val name: String,

    @Part("email_address")
    val email_address: String,

    @Part("password")
    val password: String
)

data class UserSignIn(
    val email_address: String,
    val password: String
)