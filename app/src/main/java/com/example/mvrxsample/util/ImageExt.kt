package com.example.mvrxsample.util

import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageExt {
    @JvmStatic
    fun ImageView.loadImage(imgUrl: String?) {
        Glide.with(this)
            .load(imgUrl)
            .into(this)
    }
}
