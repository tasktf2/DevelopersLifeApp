package com.setjy.developerslifeapp.presentation.view

import com.setjy.developerslifeapp.presentation.base.BaseView

interface RandomView : BaseView {
    fun showRandom(url: String, description: String)
    fun showError()
}