package com.polaris04.sleepingcaffeine.presentation.home

import com.polaris04.sleepingcaffeine.data.entity.caffeine.UserCaffeineEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity

sealed class HomeState {
    object UnInitialized: HomeState()
    object Loading: HomeState()
    data class Success(
        val drinkList: UserCaffeineEntity?
    ): HomeState()
    object Error:HomeState()

}