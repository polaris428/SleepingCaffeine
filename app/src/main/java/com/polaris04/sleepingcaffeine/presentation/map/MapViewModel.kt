package com.polaris04.sleepingcaffeine.presentation.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polaris04.sleepingcaffeine.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class MapViewModel : BaseViewModel() {
    private var _mapState = MutableLiveData<MapState>(MapState.UnInitialized)
    val mapState: LiveData<MapState> = _mapState

    override fun fetchData() = viewModelScope.launch {
        setState(MapState.UnInitialized)
    }

    private fun setState(state: MapState) {
        _mapState.postValue(state)
    }
}