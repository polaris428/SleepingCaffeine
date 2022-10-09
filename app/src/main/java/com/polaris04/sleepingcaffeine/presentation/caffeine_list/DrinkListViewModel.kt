package com.polaris04.sleepingcaffeine.presentation.caffeine_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.polaris04.sleepingcaffeine.domain.drink.GetDrinkListUseCase
import com.polaris04.sleepingcaffeine.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class DrinkListViewModel(
    private var getDrinkListUseCase: GetDrinkListUseCase
) : BaseViewModel() {
    private var _drinkListState = MutableLiveData<DrinkListState>(DrinkListState.UnInitialized)
    var drinkListState: LiveData<DrinkListState> = _drinkListState

    override fun fetchData(): Job = viewModelScope.launch {
        setState(DrinkListState.Loading)
        setState(DrinkListState.Success(getDrinkListUseCase()))

    }

    private fun setState(state: DrinkListState) {
        _drinkListState.postValue(state)
    }

}