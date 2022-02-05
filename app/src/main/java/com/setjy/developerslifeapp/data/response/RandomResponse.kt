package com.setjy.developerslifeapp.data.response

import com.google.gson.annotations.SerializedName

data class RandomResponse(
    @SerializedName("gifURL")
    val url: String,
    @SerializedName("description")
    val description: String
)
