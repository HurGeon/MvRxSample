package com.example.mvrxsample.presenter.news

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.example.mvrxsample.MyApplication
import com.example.mvrxsample.databinding.FragmentNewsBinding
import javax.inject.Inject

class NewsFragment : BaseMvRxFragment() {

    private val viewModel: NewsViewModel by fragmentViewModel(NewsViewModel::class)

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: NewsViewModel.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        val view = binding.root

        setupRecyclerViewAdapter()

        return view
    }

    private fun setupRecyclerViewAdapter() {
        binding.recyclerView.layoutManager = LinearLayoutManager(binding.root.context)
        binding.recyclerView.adapter = NewsListAdapter()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as MyApplication).appComponent.inject(this)
    }

    override fun invalidate() {
        withState(viewModel) {
            (binding.recyclerView.adapter as NewsListAdapter).submitList(it.newsList.invoke())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}