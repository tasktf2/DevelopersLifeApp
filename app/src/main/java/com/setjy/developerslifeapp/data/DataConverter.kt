package com.setjy.developerslifeapp.data

import android.util.Log
import com.setjy.developerslifeapp.data.response.RandomResponse
import com.setjy.developerslifeapp.presentation.model.RandomItem

object DataConverter {
    fun convertToPresentation(randomResponse: RandomResponse): RandomItem {
        val gif = randomResponse
        Log.d("Convertto","${gif.url},${gif.description}")
        return RandomItem(gif.url, gif.description)
    }
}