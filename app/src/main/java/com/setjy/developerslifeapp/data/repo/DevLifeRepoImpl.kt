package com.setjy.developerslifeapp.data.repo

import android.util.Log
import com.setjy.developerslifeapp.data.DataConverter
import com.setjy.developerslifeapp.data.network.DevLifeApi
import com.setjy.developerslifeapp.presentation.model.RandomItem
import io.reactivex.rxjava3.core.Single

class DevLifeRepoImpl(private val api: DevLifeApi) : DevLifeRepo {
    override fun getRandom(): Single<RandomItem> {
        return api.getRandom()
            .map(DataConverter::convertToPresentation)
            .execution()
    }


}