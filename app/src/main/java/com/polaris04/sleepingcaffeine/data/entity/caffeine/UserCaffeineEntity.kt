package com.polaris04.sleepingcaffeine.data.entity.caffeine

import com.polaris04.sleepingcaffeine.data.entity.drink.DrinkEntity

data class UserCaffeineEntity(var date:String,var caffeine:String,var drinkEntities:List<DrinkEntity>)
