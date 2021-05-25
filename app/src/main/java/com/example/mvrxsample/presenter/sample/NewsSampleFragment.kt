package com.example.mvrxsample.presenter.sample

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.mvrxsample.MyApplication
import com.example.mvrxsample.R
import kotlinx.android.synthetic.main.fragment_news_sample.*
import javax.inject.Inject

class NewsSampleFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: NewsSampleViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        observeLiveData()
        return inflater.inflate(R.layout.fragment_news_sample, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as MyApplication).appComponent.inject(this)
    }

    fun observeLiveData() {
        viewModel.testStr.observe(this.viewLifecycleOwner, {
            tv_test.text = viewModel.testStr.toString()
        })
    }
}
