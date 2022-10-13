package com.polaris04.sleepingcaffeine.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.cleanarchitectureshoppingapp.data.preference.PreferenceManager
import com.polaris04.sleepingcaffeine.domain.caffeine.GetUserCaffeineUseCase
import com.polaris04.sleepingcaffeine.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class HomeViewModel(
    var getUserCaffeineUseCase: GetUserCaffeineUseCase,
    var preferenceManager: PreferenceManager
) : BaseViewModel() {
    private var _homeState = MutableLiveData<HomeState>(HomeState.UnInitialized)
    val homeState: LiveData<HomeState> = _homeState
    override fun fetchData() = viewModelScope.launch {
        setState(HomeState.Loading)
        getUserCaffeineUseCase(preferenceManager.getIdToken())?.let {
            setState(HomeState.Success(it))
        } ?: kotlin.run {
            setState(HomeState.Error)
        }

    }

    private fun setState(state: HomeState) {
        _homeState.postValue(state)

    }



}