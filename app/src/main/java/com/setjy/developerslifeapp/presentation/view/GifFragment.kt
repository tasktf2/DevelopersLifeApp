package com.setjy.developerslifeapp.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.setjy.developerslifeapp.R
import com.setjy.developerslifeapp.databinding.FragmentGifBinding
import com.setjy.developerslifeapp.presentation.base.BaseFragment
import com.setjy.developerslifeapp.presentation.presenter.GifPresenter
import com.setjy.developerslifeapp.presentation.view.adapter.Page

class GifFragment : BaseFragment<GifView, GifPresenter>(), GifView {

    private lateinit var progressDrawable: CircularProgressDrawable

    companion object {
        private const val ARG_PAGE: String = "ARG_PAGE"
        private const val TAG: String = "GifFragment"
        private const val EMPTY_TEXT: String = "В данной категории пусто!"
        private const val DEFAULT_CATEGORY: String = "top"
    }

    fun newInstance(page: Page): GifFragment = GifFragment().apply {
        val bundle = Bundle()
        bundle.putSerializable(ARG_PAGE, page)
        arguments = bundle
    }

    private var page: Page? = null

    private val binding: FragmentGifBinding by viewBinding()

    override fun initPresenter() {
        presenter = GifPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            page = arguments?.getSerializable(ARG_PAGE) as Page
        }
        progressDrawable = CircularProgressDrawable(requireContext()).apply {
            strokeWidth = 5f
            centerRadius = 30f
            start()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gif, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.itView = this
        presenter.loadGif(
            category = page?.category ?: DEFAULT_CATEGORY,
            page = (page?.pageNumber ?: 0)
        )
        with(binding) {
            btnNext.setOnClickListener { presenter.nextGif() }
            btnBack.setOnClickListener { presenter.prevGif() }
            tvBtnRetryConnection.setOnClickListener {
                presenter.loadGif(
                    category = page?.category ?: DEFAULT_CATEGORY,
                    page = (page?.pageNumber ?: 0)
                )

            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.itView = null
    }


    override fun showGif(url: String, description: String) {
        showContent()
        Log.d(TAG, "Got gif with url: $url, description: $description")
        Glide.with(requireContext())
            .asGif()
            .load(url)
            .placeholder(progressDrawable)
            .into(binding.ivGif)

        binding.tvDescription.text = description
    }

    private fun showContent() {
        with(binding) {
            if (cvContent.visibility == View.GONE) {
                cvContent.visibility = View.VISIBLE
                ivGif.visibility = View.VISIBLE
                tvDescription.visibility = View.VISIBLE
                btnBack.visibility = View.VISIBLE
                btnNext.visibility = View.VISIBLE
                layoutConnectionLost.visibility = View.GONE
            }
        }

    }


    override fun showError() {
        Log.d(TAG, "Cannot upload a gif!")
        showConnectionLost()

    }

    private fun showConnectionLost() {
        with(binding) {
            cvContent.visibility = View.GONE
            ivGif.visibility = View.GONE
            tvDescription.visibility = View.GONE
            btnBack.visibility = View.GONE
            btnNext.visibility = View.GONE
            layoutConnectionLost.visibility = View.VISIBLE
        }
    }

    override fun showContentIsEmpty() {
        showContent()
        binding.tvDescription.text = EMPTY_TEXT
    }
}
