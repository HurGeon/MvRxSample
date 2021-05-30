package com.example.mvrxsample.presenter.news

import androidx.recyclerview.widget.RecyclerView
import com.example.mvrxsample.databinding.ItemNewsBinding
import com.example.mvrxsample.domain.model.News
import com.example.mvrxsample.util.ImageExt.loadImageWithThumbnail

class NewsViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: News) {
        binding.tvTitle.text = item.title
        binding.tvDesc.text = item.description
        binding.imageView.loadImageWithThumbnail(item.imageUrl)
    }
}
