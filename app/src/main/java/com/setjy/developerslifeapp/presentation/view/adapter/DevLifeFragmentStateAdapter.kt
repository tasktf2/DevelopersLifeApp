package com.setjy.developerslifeapp.presentation.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.setjy.developerslifeapp.presentation.view.GifFragment
import java.io.Serializable

class DevLifeFragmentStateAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    private val listOfFragments = mutableListOf<Fragment>(
        GifFragment().newInstance(Page.LATEST),
        GifFragment().newInstance(Page.TOP),
        GifFragment().newInstance(Page.HOT)
    )

    override fun getItemCount(): Int {
        return listOfFragments.size
    }

    override fun createFragment(position: Int): Fragment =listOfFragments[position]
}

enum class Page(val pageNumber: Int, val category: String) : Serializable {
    LATEST(0, "latest"),
    TOP(0, "top"),
    HOT(0, "hot")
}
