package com.asoom.repositoriesgit.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageBindingAdapter {
    @BindingAdapter("loadImageFromUrl")
    @JvmStatic
    fun loadImageFromUrl(imageView: ImageView, imageUrl: String?) {
        if (!imageUrl.isNullOrBlank()) {
            Glide.with(imageView.context)
                .load(imageUrl)
                .into(imageView)
        }
    }
}

