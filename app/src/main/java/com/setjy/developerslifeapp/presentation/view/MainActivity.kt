package com.setjy.developerslifeapp.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.setjy.developerslifeapp.R
import com.setjy.developerslifeapp.databinding.ActivityMainBinding
import com.setjy.developerslifeapp.presentation.view.adapter.DevLifeFragmentStateAdapter

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = DevLifeFragmentStateAdapter(supportFragmentManager, lifecycle)
        with(binding) {
            viewPager.adapter = adapter
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                val tabTitles = listOf("Последние", "Лучшие", "Горячие")
                tab.text = tabTitles[position]
            }.attach()
        }

    }
}