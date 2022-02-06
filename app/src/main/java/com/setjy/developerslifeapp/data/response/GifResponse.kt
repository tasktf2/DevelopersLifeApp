package com.setjy.developerslifeapp.data.response

import com.google.gson.annotations.SerializedName

data class GifResponse(
    @SerializedName("result")
    val files: List<GifRemote>
)

data class GifRemote(
    @SerializedName("gifURL")
    val url: String,
    @SerializedName("description")
    val description: String
)
