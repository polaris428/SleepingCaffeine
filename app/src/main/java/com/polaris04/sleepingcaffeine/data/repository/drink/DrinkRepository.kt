package com.polaris04.sleepingcaffeine.data.repository.drink

import android.util.Log
import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.DrinkEntity
import com.polaris04.sleepingcaffeine.data.network.DrinkApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DrinkRepository(
    private var drinkApi: DrinkApiService,
    private val ioDispatcher: CoroutineDispatcher
) : DrinkRepositoryInterface {

    override suspend fun getDrinkList(): CaffeineDrinkEntity? = withContext(ioDispatcher) {
        val response = drinkApi.getDrinkList()
        return@withContext if (response.isSuccessful) {
            Log.d(response.code().toString(),response.message().toString())
            Log.d("ㅁㅇㄴㄻㄹㅇ"+response.body().toString(),"성공")

            response.body()
        } else {
            Log.d("성송","성공")
            null
        }
    }

    override suspend fun getDrink(drinkId: String): DrinkEntity? = withContext(ioDispatcher) {
        val response = drinkApi.getDrink(drinkId)
        Log.d(response.message(), response.code().toString())
        return@withContext if (response.isSuccessful) {
            response.body()

        } else {
            null
        }
    }
}