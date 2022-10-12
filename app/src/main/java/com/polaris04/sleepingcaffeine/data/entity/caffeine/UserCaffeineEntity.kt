package com.polaris04.sleepingcaffeine.data.entity.caffeine

import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.Drink

data class UserCaffeineEntity(var date:String,var caffeine:String,var drinks:List<Drink>)
