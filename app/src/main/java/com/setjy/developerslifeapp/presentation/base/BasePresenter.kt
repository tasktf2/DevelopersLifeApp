package com.setjy.developerslifeapp.presentation.base

import com.setjy.developerslifeapp.GlobalDI

abstract class BasePresenter<V : BaseView> {
    var itView: V? = null
    lateinit var globalDI: GlobalDI
}