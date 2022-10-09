package com.polaris04.sleepingcaffeine.extensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.polaris04.sleepingcaffeine.R

object BindingConversions{
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView : ImageView, url : String){
        Glide.with(imageView.context).load(url)
            .error(R.drawable.ic_launcher_background)
            .into(imageView)
    }

}