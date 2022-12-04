package com.polaris04.sleepingcaffeine.presentation.home

import com.polaris04.sleepingcaffeine.data.entity.caffeine.UserCaffeineEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.DrinkEntity

sealed class HomeState {
    object UnInitialized: HomeState()
    object Loading: HomeState()
    data class Success(
        val drinkList: List<DrinkEntity>
    ): HomeState()
    object Error:HomeState()

}