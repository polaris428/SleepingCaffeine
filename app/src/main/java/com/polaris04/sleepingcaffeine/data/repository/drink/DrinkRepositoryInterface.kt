package com.polaris04.sleepingcaffeine.data.repository.drink

import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity

interface DrinkRepositoryInterface {

    suspend fun getDrink():CaffeineDrinkEntity
}