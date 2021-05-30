package com.example.mvrxsample.util

import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageExt {
    @JvmStatic
    fun ImageView.loadImageWithThumbnail(imgUrl: String?) {
        Glide.with(this)
            .load(imgUrl)
            .thumbnail(0.2f)
            .into(this)
    }
}
