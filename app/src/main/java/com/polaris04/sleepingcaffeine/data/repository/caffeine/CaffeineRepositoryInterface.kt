package com.polaris04.sleepingcaffeine.data.repository.caffeine

interface  CaffeineRepositoryInterface{
    suspend fun postCaffeine(token:String,caffeine:Int,drink:String):Boolean
}