package com.setjy.developerslifeapp.presentation.view

import com.setjy.developerslifeapp.presentation.base.BaseView

interface GifView : BaseView {
    fun showGif(url: String, description: String)
    fun showError()
    fun showContentIsEmpty()
}