package com.example.flowersmvvm.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("bind:imageUrl")
fun setImageUrl(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load( "http://services.hanselandpetal.com/photos/" + url).into(imageView)
}