package com.polaris04.sleepingcaffeine.domain.drink

import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.data.repository.drink.DrinkRepositoryInterface
import com.polaris04.sleepingcaffeine.domain.UseCase

class GetDrinkListUseCase(var drinkRepositoryInterface: DrinkRepositoryInterface) : UseCase {
    suspend operator fun invoke(): CaffeineDrinkEntity {
        return drinkRepositoryInterface.getDrink()
    }
}