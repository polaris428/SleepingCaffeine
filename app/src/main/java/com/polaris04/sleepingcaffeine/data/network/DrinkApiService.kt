package com.polaris04.sleepingcaffeine.data.network

import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import retrofit2.Response
import retrofit2.http.GET

interface DrinkApiService {
    @GET("api/drink")
    suspend fun getDrink():Response<CaffeineDrinkEntity>

}