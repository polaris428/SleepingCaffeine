package com.polaris04.sleepingcaffeine.domain.caffeine

import com.polaris04.sleepingcaffeine.data.repository.caffeine.CaffeineRepositoryInterface
import com.polaris04.sleepingcaffeine.domain.UseCase

class PostCaffeineUseCase(var caffeineRepositoryInterface: CaffeineRepositoryInterface):UseCase{
    suspend operator fun invoke(token:String,caffeine:Int,drinkId:String):Boolean{
        return caffeineRepositoryInterface.postCaffeine(token,caffeine,drinkId)
    }
}