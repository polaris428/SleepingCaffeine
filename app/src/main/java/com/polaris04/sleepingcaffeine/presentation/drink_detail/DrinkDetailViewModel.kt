package com.polaris04.sleepingcaffeine.presentation.drink_detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.cleanarchitectureshoppingapp.data.preference.PreferenceManager
import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.domain.caffeine.PostCaffeineUseCase
import com.polaris04.sleepingcaffeine.domain.drink.GetDrinkListUseCase
import com.polaris04.sleepingcaffeine.domain.drink.GetDrinkUseCase
import com.polaris04.sleepingcaffeine.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class DrinkDetailViewModel(
    private var drinkId: String,
    private var getDrinkUseCase: GetDrinkUseCase,
    private var getDrinkListUseCase: GetDrinkListUseCase,
    private var postCaffeineUseCase: PostCaffeineUseCase,
    private var preferenceManager: PreferenceManager
) : BaseViewModel() {
    private var _drinkDetailState =
        MutableLiveData<DrinkDetailState>(DrinkDetailState.UnInitialized)
    val drinkDetailState: LiveData<DrinkDetailState> = _drinkDetailState

    override fun fetchData(): Job = viewModelScope.launch {
        setState(DrinkDetailState.ItemLoading)
        setState(DrinkDetailState.ListLoading)
        setState(DrinkDetailState.ListSuccess(getDrinkListUseCase()))
        setState(DrinkDetailState.ItemSuccess(getDrinkUseCase(drinkId)))


    }

    private fun setState(state: DrinkDetailState) {
        _drinkDetailState.postValue(state)
    }

    fun postCaffeine(caffeine:Int,drinkId: String)=viewModelScope.launch{
        if(postCaffeineUseCase(getToken(),caffeine,drinkId)){
            setState(DrinkDetailState.AddDrink)
        }else{
            setState(DrinkDetailState.Error)
        }
    }
    private fun getToken():String{
        return  preferenceManager.getIdToken()
    }

}