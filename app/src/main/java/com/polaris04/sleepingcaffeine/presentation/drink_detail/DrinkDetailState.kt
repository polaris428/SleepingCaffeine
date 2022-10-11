package com.polaris04.sleepingcaffeine.presentation.drink_detail

import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.Drink
import com.polaris04.sleepingcaffeine.presentation.caffeine_list.DrinkListState

sealed class DrinkDetailState {
    object UnInitialized : DrinkDetailState()

    object ListLoading : DrinkDetailState()

    object ItemLoading : DrinkDetailState()

    data class ListSuccess(
        val caffeineDrinkEntity: CaffeineDrinkEntity
    ) : DrinkDetailState()

    data class ItemSuccess(
        val drink: Drink
    ) : DrinkDetailState()
}