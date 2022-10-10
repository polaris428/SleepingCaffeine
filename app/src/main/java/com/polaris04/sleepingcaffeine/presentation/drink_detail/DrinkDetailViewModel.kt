package com.polaris04.sleepingcaffeine.presentation.drink_detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.polaris04.sleepingcaffeine.domain.drink.GetDrinkUseCase
import com.polaris04.sleepingcaffeine.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class DrinkDetailViewModel (private var drinkId:String,private var getDrinkUseCase: GetDrinkUseCase): BaseViewModel() {
    private var _drinkDetailState =
        MutableLiveData<DrinkDetailState>(DrinkDetailState.UnInitialized)
     val drinkDetailState: LiveData<DrinkDetailState> = _drinkDetailState

    override fun fetchData(): Job = viewModelScope.launch {
        setState(DrinkDetailState.Loading)
        Log.d(drinkId,"아이디랍니다")
        setState(DrinkDetailState.Success(getDrinkUseCase(drinkId)))


    }
    private fun setState(state: DrinkDetailState){
        _drinkDetailState.postValue(state)
    }
}