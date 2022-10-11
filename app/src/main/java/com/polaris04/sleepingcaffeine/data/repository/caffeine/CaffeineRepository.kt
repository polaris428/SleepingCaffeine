package com.polaris04.sleepingcaffeine.data.repository.caffeine

import android.util.Log
import com.polaris04.sleepingcaffeine.data.entity.caffeine.PostCaffeineEntity
import com.polaris04.sleepingcaffeine.data.network.DrinkApiService

class CaffeineRepository(var drinkApiService: DrinkApiService):CaffeineRepositoryInterface{
    override suspend fun postCaffeine( token:String,caffeine:Int,drinkId:String) :Boolean{
        val response=drinkApiService.postDrink(token, PostCaffeineEntity(caffeine,drinkId))
        return try {
            response.body()!!.result
        }catch(e:Exception){
            false
        }
    }

}