package com.setjy.developerslifeapp.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.setjy.developerslifeapp.R
import com.setjy.developerslifeapp.databinding.FragmentRandomBinding
import com.setjy.developerslifeapp.presentation.base.BaseFragment
import com.setjy.developerslifeapp.presentation.presenter.RandomPresenter

class RandomFragment : BaseFragment<RandomView, RandomPresenter>(), RandomView {

    private val binding: FragmentRandomBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_random, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getRandom()
        presenter.itView = this

    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.itView = null
    }

    override fun initPresenter() {
        presenter = RandomPresenter()
    }

    private fun setRandom(url: String) {
        Glide.with(requireContext())
            .asGif()
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.gif)

    }

    override fun showRandom(url: String, description: String) {
        setRandom(url)
        Log.d("Frag", "$url, $description")
        binding.tvDescription.text = description
    }

    override fun showError() {
        Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show()
    }
}
