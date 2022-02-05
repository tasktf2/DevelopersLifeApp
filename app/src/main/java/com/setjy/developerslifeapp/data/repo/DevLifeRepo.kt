package com.setjy.developerslifeapp.data.repo

import com.setjy.developerslifeapp.presentation.model.RandomItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

interface DevLifeRepo {
    fun getRandom(): Single<RandomItem>

    fun <T> Single<T>.execution(): Single<T> {
        return this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}