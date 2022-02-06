package com.setjy.developerslifeapp.data.repo

import android.util.Log
import com.setjy.developerslifeapp.data.DataConverter
import com.setjy.developerslifeapp.data.network.DevLifeApi
import com.setjy.developerslifeapp.data.response.GifResponse
import com.setjy.developerslifeapp.presentation.model.GifItem
import io.reactivex.rxjava3.core.Single

class DevLifeRepoImpl(private val api: DevLifeApi) : DevLifeRepo {

    companion object {
        private const val TAG: String = "DevLifeRepoImpl"
    }

    private val cachedResponses: HashMap<String, GifResponse> = hashMapOf()

    override fun getGif(category: String, page: Int): Single<List<GifItem>> {
        val cacheKey = getCacheKey(category, page)
        val cachedResponse = cachedResponses[cacheKey]
        val singleRequest = if (cachedResponse != null) {
            Log.d(TAG, "load from cache, category: $category, page: $page, $cachedResponse")
            Single.just(cachedResponse)
        } else {
            api.getGif(category, page).doOnSuccess {
                Log.d(TAG, "load from remote, category: $category, page: $page, $it")
                cachedResponses[cacheKey] = it
            }
        }
        return singleRequest
            .map(DataConverter::convertToPresentation)
            .execution()
    }

    private fun getCacheKey(category: String, page: Int): String = "$category$page"


}