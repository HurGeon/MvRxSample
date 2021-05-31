package com.example.mvrxsample.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mvrxsample.R

object ImageExt {
    @JvmStatic
    fun ImageView.loadImageWithThumbnail(imgUrl: String?) {
        Glide.with(this)
            .load(imgUrl)
            .thumbnail(0.2f)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(this)
    }
}
