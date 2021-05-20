package com.example.mvrxsample.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.example.mvrxsample.R
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : BaseMvRxFragment() {

    private val viewModel: NewsViewModel by fragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun invalidate() {
        withState(viewModel){ state ->  textView.text = state.news.toString()}
    }
}
