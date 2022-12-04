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
    private val userDrinkDao: UserDrinkDao) :
    CaffeineRepositoryInterface {
    override suspend fun postCaffeine(drinkEntity: DrinkEntity) {
      userDrinkDao.insert(drinkEntity)

    }

    override suspend fun getCaffeine(): List<DrinkEntity> {
      return userDrinkDao.getAll()

    }

}