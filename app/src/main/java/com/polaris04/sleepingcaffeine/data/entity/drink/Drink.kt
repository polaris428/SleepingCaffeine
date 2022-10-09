package com.polaris04.sleepingcaffeine.data.entity.drink

import android.net.Uri

data class Drink(var _id:String,var name:String,var photo:Uri,var description:String,var caffeine:Int,var like:List<Like>)
