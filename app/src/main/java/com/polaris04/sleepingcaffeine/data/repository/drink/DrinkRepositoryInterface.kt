package com.polaris04.sleepingcaffeine.data.repository.drink

import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.DrinkEntity

interface DrinkRepositoryInterface {

    suspend fun getDrinkList():CaffeineDrinkEntity?

    suspend fun getDrink(drinkId:String):DrinkEntity?
}