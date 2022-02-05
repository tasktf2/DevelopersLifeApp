package com.setjy.developerslifeapp.presentation.presenter

import android.util.Log
import com.setjy.developerslifeapp.data.repo.DevLifeRepoImpl
import com.setjy.developerslifeapp.presentation.base.BasePresenter
import com.setjy.developerslifeapp.presentation.view.RandomView

class RandomPresenter : BasePresenter<RandomView>() {
    private val repo: DevLifeRepoImpl by lazy { globalDI.repoDevLife }
    fun getRandom() {
        repo.getRandom().subscribe({ gif ->
            Log.d(TAG,"Sent gif and desc")
            itView?.showRandom(gif.url, gif.description)
        }, {
            Log.d(TAG, "An error has occurred!")
            itView?.showError()
        })
    }

    companion object {
        private const val TAG = "RandomPresenter"
    }
}