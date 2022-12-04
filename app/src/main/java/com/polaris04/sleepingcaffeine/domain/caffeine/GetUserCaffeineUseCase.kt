package com.polaris04.sleepingcaffeine.domain.caffeine

import com.polaris04.sleepingcaffeine.data.entity.caffeine.UserCaffeineEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.DrinkEntity
import com.polaris04.sleepingcaffeine.data.repository.caffeine.CaffeineRepositoryInterface
import com.polaris04.sleepingcaffeine.domain.UseCase

class GetUserCaffeineUseCase(var caffeineRepositoryInterface: CaffeineRepositoryInterface):UseCase {
    suspend operator fun invoke():List<DrinkEntity>{
        return caffeineRepositoryInterface.getCaffeine()
    }
}