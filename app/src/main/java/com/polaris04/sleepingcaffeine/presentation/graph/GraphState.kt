package com.polaris04.sleepingcaffeine.presentation.graph

import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.presentation.drink_detail.DrinkDetailState

sealed class GraphState {
    object UnInitialized : GraphState()

    object ListSuccess:GraphState()



}