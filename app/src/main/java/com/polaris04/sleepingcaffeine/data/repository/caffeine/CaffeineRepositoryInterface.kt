package com.polaris04.sleepingcaffeine.data.repository.caffeine

import com.polaris04.sleepingcaffeine.data.entity.caffeine.UserCaffeineEntity

interface  CaffeineRepositoryInterface{
    suspend fun postCaffeine(token:String,caffeine:Int,drink:String):Boolean

    suspend fun getCaffeine(token: String):UserCaffeineEntity?
}