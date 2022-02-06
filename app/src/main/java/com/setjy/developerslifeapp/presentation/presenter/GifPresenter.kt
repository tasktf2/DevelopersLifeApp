package com.setjy.developerslifeapp.presentation.presenter

import android.util.Log
import com.setjy.developerslifeapp.data.repo.DevLifeRepo
import com.setjy.developerslifeapp.presentation.base.BasePresenter
import com.setjy.developerslifeapp.presentation.model.GifItem
import com.setjy.developerslifeapp.presentation.view.GifFragment
import com.setjy.developerslifeapp.presentation.view.GifView

class GifPresenter : BasePresenter<GifView>() {


    companion object {
        private const val INITIAL_GIF: Int = 0
        private const val TAG: String = "GifPresenter"
    }

    private val repo: DevLifeRepo by lazy { globalDI.repoDevLife }

    private var currentGifs: MutableList<GifItem> = mutableListOf()

    private var currentCategory: String? = null

    private var currentPageNumber: Int? = null

    private var currentGifNumber: Int = INITIAL_GIF
    fun loadGif(category: String, page: Int) {
        currentCategory = category
        currentPageNumber = page
        repo.getGif(category, page).subscribe({ gifItemList ->
            if (gifItemList.isNotEmpty()) {
                currentGifs.addAll(gifItemList)
                currentGifs = currentGifs.distinct().toMutableList()
                itView?.showGif(currentGifs[INITIAL_GIF].url, currentGifs[INITIAL_GIF].description)
            } else itView?.showContentIsEmpty()
        }, {
            Log.d(TAG, "$it")
            itView?.showError()
        })
    }

    fun nextGif() {
        val immutableGifs = currentGifs
        if (!immutableGifs.isNullOrEmpty() && (currentGifNumber + 1) < immutableGifs.size) {
            currentGifNumber++
            itView?.showGif(
                immutableGifs[currentGifNumber].url,
                immutableGifs[currentGifNumber].description
            )
        } else {
            tryLoadNextPage()
        }
    }

    private fun tryLoadNextPage() {
        if (currentPageNumber != null) {
            currentPageNumber = currentPageNumber!! + 1
        }
        loadGif(currentCategory!!, currentPageNumber!!)
    }
    fun prevGif() {
        val immutableGifs=currentGifs
        if (!immutableGifs.isNullOrEmpty() && (currentGifNumber - 1) >= 0) {
            currentGifNumber--
            itView?.showGif(immutableGifs[currentGifNumber].url,immutableGifs[currentGifNumber].description)
        }
    }

}