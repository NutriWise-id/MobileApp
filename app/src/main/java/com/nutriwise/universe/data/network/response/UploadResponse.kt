package com.nutriwise.universe.data.network.response

import com.google.gson.annotations.SerializedName

data class UploadResponse(

    @field:SerializedName("prediction")
    val prediction: String? = null,

    @field:SerializedName("status")
    var status: String? = null,
)