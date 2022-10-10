package com.polaris04.sleepingcaffeine.presentation.drink_detail

import com.polaris04.sleepingcaffeine.data.entity.drink.Drink

sealed class DrinkDetailState {
    object UnInitialized: DrinkDetailState()
    object Loading: DrinkDetailState()
    data class Success(
        val drink: Drink
    ): DrinkDetailState()
}