package com.polaris04.sleepingcaffeine.data.repository.drink

import android.util.Log
import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.data.network.DrinkApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DrinkRepository(
    private var drinkApi: DrinkApiService,
    private val ioDispatcher: CoroutineDispatcher
) : DrinkRepositoryInterface {

    override suspend fun getDrink(): CaffeineDrinkEntity = withContext(ioDispatcher) {
        Log.d("adfs", "fdajjdkjfaahlkdj")
        val response = drinkApi.getDrink()
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
}