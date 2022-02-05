package com.setjy.developerslifeapp.presentation.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.setjy.developerslifeapp.app.DevLifeApplication

abstract class BaseFragment<V : BaseView, P : BasePresenter<V>> : Fragment(), BaseView {
    lateinit var presenter: P
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPresenter()
        val di = (requireContext().applicationContext as DevLifeApplication).globalDI
        presenter.globalDI = di

    }
}