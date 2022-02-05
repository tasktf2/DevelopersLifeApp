package com.setjy.developerslifeapp

import com.setjy.developerslifeapp.data.network.DevLifeApi
import com.setjy.developerslifeapp.data.network.NetworkService
import com.setjy.developerslifeapp.data.repo.DevLifeRepoImpl
import retrofit2.Retrofit

class GlobalDI {

    private val retrofitDevLife: Retrofit = NetworkService.retrofit
    private val apiDevLife: DevLifeApi = provideApi(retrofitDevLife)
    val repoDevLife = provideRepo(apiDevLife)

    private fun provideApi(retrofit: Retrofit): DevLifeApi = retrofit.create(DevLifeApi::class.java)
    private fun provideRepo(api: DevLifeApi): DevLifeRepoImpl = DevLifeRepoImpl(api)
}