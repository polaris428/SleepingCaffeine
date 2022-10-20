package com.polaris04.sleepingcaffeine.domain.drink

import com.polaris04.sleepingcaffeine.data.entity.drink.DrinkEntity
import com.polaris04.sleepingcaffeine.data.repository.drink.DrinkRepositoryInterface
import com.polaris04.sleepingcaffeine.domain.UseCase

class GetDrinkUseCase(
    private var drinkRepositoryInterface: DrinkRepositoryInterface,

) : UseCase {
    suspend operator fun invoke( drinkId: String): DrinkEntity? {
        return drinkRepositoryInterface.getDrink(drinkId)

    }
}