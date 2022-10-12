package com.polaris04.sleepingcaffeine.presentation.caffeine_list

import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity

sealed class DrinkListState {
    object UnInitialized:DrinkListState()
    object Loading:DrinkListState()
    data class Success(
        val drinkList: CaffeineDrinkEntity?
    ):DrinkListState()
    object Error:DrinkListState()


}