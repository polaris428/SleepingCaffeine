package com.polaris04.sleepingcaffeine.presentation.drink_detail

import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.DrinkEntity

sealed class DrinkDetailState {
    object UnInitialized : DrinkDetailState()

    object ListLoading : DrinkDetailState()

    object ItemLoading : DrinkDetailState()

    data class ListSuccess(
        val caffeineDrinkEntity: CaffeineDrinkEntity
    ) : DrinkDetailState()

    data class ItemSuccess(
        val drinkEntity: DrinkEntity
    ) : DrinkDetailState()

    object AddDrink :DrinkDetailState()

    object Error:DrinkDetailState()
}