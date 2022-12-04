package com.polaris04.sleepingcaffeine.data.repository.caffeine

import com.polaris04.sleepingcaffeine.data.entity.caffeine.UserCaffeineEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.DrinkEntity

interface  CaffeineRepositoryInterface{
    suspend fun postCaffeine(drinkEntity: DrinkEntity)

    suspend fun getCaffeine():List<DrinkEntity>
}