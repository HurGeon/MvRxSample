package com.example.mvrxsample.presenter.news

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.example.mvrxsample.MyApplication
import com.example.mvrxsample.R
import dagger.assisted.AssistedInject
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

class NewsFragment : BaseMvRxFragment() {

    private val viewModel: NewsViewModel by fragmentViewModel(NewsViewModel::class)

    @Inject
    lateinit var viewModelFactory: NewsViewModel.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as MyApplication).appComponent.inject(this)
    }

    override fun invalidate() {
        withState(viewModel){ state ->  textView.text = state.news.toString()}
    }
}
