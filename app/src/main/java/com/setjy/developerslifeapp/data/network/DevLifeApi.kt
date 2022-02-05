package com.setjy.developerslifeapp.data.network

import com.setjy.developerslifeapp.data.response.RandomResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface DevLifeApi {
    @GET("random?json=true")
    fun getRandom():Single<RandomResponse>
}