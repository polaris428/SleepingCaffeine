package com.polaris04.sleepingcaffeine.data.repository.caffeine

import android.util.Log
import com.polaris04.sleepingcaffeine.data.entity.caffeine.PostCaffeineEntity
import com.polaris04.sleepingcaffeine.data.entity.caffeine.UserCaffeineEntity
import com.polaris04.sleepingcaffeine.data.network.DrinkApiService
import kotlinx.coroutines.Dispatchers

class CaffeineRepository(var drinkApiService: DrinkApiService):CaffeineRepositoryInterface{
    override suspend fun postCaffeine( token:String,caffeine:Int,drinkId:String) :Boolean{
        val response=drinkApiService.postDrink(token, PostCaffeineEntity(caffeine,drinkId))
        return try {
            response.body()!!.result
        }catch(e:Exception){
            false
        }
    }

    override suspend fun getCaffeine(token: String):UserCaffeineEntity? = with(Dispatchers.IO   ){
        val response=drinkApiService.getUserCaffeine(token)
        return try {
            Log.d(response.body().toString(),"성공")
            response.body()
        }catch (e:Exception){
            Log.d(response.message(),response.message())
            null
        }
    }

}