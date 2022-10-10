package com.polaris04.sleepingcaffeine.data.repository.drink

import android.util.Log
import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.Drink
import com.polaris04.sleepingcaffeine.data.network.DrinkApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DrinkRepository(
    private var drinkApi: DrinkApiService,
    private val ioDispatcher: CoroutineDispatcher
) : DrinkRepositoryInterface {

    override suspend fun getDrinkList(): CaffeineDrinkEntity = withContext(ioDispatcher) {
        Log.d("adfs", "fdajjdkjfaahlkdj")
        val response = drinkApi.getDrinkList()
        Log.d("adfs", "fdajjdkjfaahlkdj")
        Log.d(response.body().toString(), response.code().toString())
        return@withContext if (response.isSuccessful) {
            Log.d(response.body().toString(), response.code().toString())
            response.body()!!
        } else {
            Log.d(response.body().toString(), response.code().toString())
            CaffeineDrinkEntity(listOf())
        }
    }

    override suspend fun getDrink(drinkId:String): Drink = withContext(ioDispatcher) {
        val response=drinkApi.getDrink(drinkId)
        Log.d(drinkId,"아아아디디")
        Log.d(response.message(),response.code().toString())
        return@withContext if (response.isSuccessful){
            Log.d(response.body()!!.description,"")
            response.body()!!

        }else{
           Drink("","","","",0, listOf())
        }
    }
}