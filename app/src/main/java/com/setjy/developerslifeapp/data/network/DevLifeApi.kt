package com.setjy.developerslifeapp.data.network

import com.setjy.developerslifeapp.data.response.GifResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface DevLifeApi {

    @GET("/{category}/{page}?json=true")
    fun getGif(
        @Path("category") category: String,
        @Path("page") page: Int,
    ): Single<GifResponse>

}