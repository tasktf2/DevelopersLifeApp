package com.setjy.developerslifeapp.data

import com.setjy.developerslifeapp.data.response.GifResponse
import com.setjy.developerslifeapp.presentation.model.GifItem

object DataConverter {
    fun convertToPresentation(gifResponse: GifResponse): List<GifItem> {
        val gifRemoteList = gifResponse.files
        return gifRemoteList.map { gifRemote ->  GifItem(gifRemote.url, gifRemote.description) }

    }
}