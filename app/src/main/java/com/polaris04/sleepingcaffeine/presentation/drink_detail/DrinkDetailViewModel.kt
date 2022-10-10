package com.polaris04.sleepingcaffeine.presentation.drink_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.polaris04.sleepingcaffeine.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class DrinkDetailViewModel : BaseViewModel() {
    private var _drinkDetailState =
        MutableLiveData<DrinkDetailState>(DrinkDetailState.UnInitialized)
     val drinkDetailState: LiveData<DrinkDetailState> = _drinkDetailState

    override fun fetchData(): Job = viewModelScope.launch {

    }
}