package com.polaris04.sleepingcaffeine.data.repository.caffeine

import android.util.Log
import com.polaris04.sleepingcaffeine.data.db.dao.UserDrinkDao
import com.polaris04.sleepingcaffeine.data.entity.caffeine.PostCaffeineEntity
import com.polaris04.sleepingcaffeine.data.entity.caffeine.UserCaffeineEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.DrinkEntity
import com.polaris04.sleepingcaffeine.data.network.DrinkApiService
import kotlinx.coroutines.Dispatchers

class CaffeineRepository(
    var drinkApiService: DrinkApiService,
    private val userDrinkDao: UserDrinkDao) :
    CaffeineRepositoryInterface {
    override suspend fun postCaffeine(drinkEntity: DrinkEntity) {
      userDrinkDao.insert(drinkEntity)

    }

    override suspend fun getCaffeine(token: String): UserCaffeineEntity? = with(Dispatchers.IO) {
        val response = drinkApiService.getUserCaffeine(token)
        return try {
            Log.d(response.body().toString(), "성공")
            response.body()
        } catch (e: Exception) {
            Log.d("패", "실패")
            Log.d(response.message(), response.message())
            null
        }
    }

}