package com.nutriwise.universe.data.network.response

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field

data class SignInResponse(
    @field:SerializedName("token")
    val token: String
)