package com.polaris04.sleepingcaffeine.domain.caffeine

import com.polaris04.sleepingcaffeine.data.entity.drink.DrinkEntity
import com.polaris04.sleepingcaffeine.data.repository.caffeine.CaffeineRepositoryInterface
import com.polaris04.sleepingcaffeine.domain.UseCase

class PostCaffeineUseCase(var caffeineRepositoryInterface: CaffeineRepositoryInterface):UseCase{
    suspend operator fun invoke(drinkEntity: DrinkEntity){
        return caffeineRepositoryInterface.postCaffeine(drinkEntity)
    }
}