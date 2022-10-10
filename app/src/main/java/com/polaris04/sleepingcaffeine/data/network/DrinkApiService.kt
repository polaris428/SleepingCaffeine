package com.polaris04.sleepingcaffeine.data.network

import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.Drink
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DrinkApiService {
    @GET("api/drink")
    suspend fun getDrinkList(): Response<CaffeineDrinkEntity>

    @GET("api/drink/{drink_id}")
    suspend fun getDrink(@Path("drink_id") drinkId: String): Response<Drink>

}