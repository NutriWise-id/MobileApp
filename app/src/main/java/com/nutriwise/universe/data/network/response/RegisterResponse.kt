package com.nutriwise.universe.data.network.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse (
    @field:SerializedName("Success")
    val Success: Boolean,

    @field:SerializedName("Message")
    val Message: String
)
