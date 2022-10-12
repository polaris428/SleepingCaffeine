package com.polaris04.sleepingcaffeine.data.network


import com.polaris04.sleepingcaffeine.data.entity.caffeine.PostCaffeineEntity
import com.polaris04.sleepingcaffeine.data.entity.caffeine.ResultEntity
import com.polaris04.sleepingcaffeine.data.entity.caffeine.UserCaffeineEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.Drink
import retrofit2.Response
import retrofit2.http.*

interface DrinkApiService {
    @GET("api/drink")
    suspend fun getDrinkList(): Response<CaffeineDrinkEntity>

    @GET("api/drink/{drink_id}")
    suspend fun getDrink(@Path("drink_id") drinkId: String): Response<Drink>

    @POST("/api/caffeine")
    suspend fun postDrink(@Header("token")token: String ,@Body postCaffeine:PostCaffeineEntity):Response<ResultEntity>
    @GET("/api/caffeine")
    suspend fun getUserCaffeine(@Header("token")token: String):Response<UserCaffeineEntity?>

}