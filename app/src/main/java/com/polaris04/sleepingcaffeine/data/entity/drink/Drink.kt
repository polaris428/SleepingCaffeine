package com.polaris04.sleepingcaffeine.data.entity.drink

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.polaris04.sleepingcaffeine.R

data class Drink(var _id:String,var name:String,var photo:String,var description:String,var caffeine:Int,var like:List<String>)


