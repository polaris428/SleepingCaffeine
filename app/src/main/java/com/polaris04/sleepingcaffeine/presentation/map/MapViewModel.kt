package com.polaris04.sleepingcaffeine.presentation.map

import android.os.Bundle
import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.polaris04.sleepingcaffeine.presentation.BaseViewModel
import kotlinx.coroutines.launch
import noman.googleplaces.Place
import noman.googleplaces.PlacesException
import noman.googleplaces.PlacesListener


internal class MapViewModel : BaseViewModel(){
    private var _mapState = MutableLiveData<MapState>(MapState.UnInitialized)
    val mapState: LiveData<MapState> = _mapState
    private var _mapMutableLiveData= MutableLiveData<GoogleMap>()
    val mapLiveData= _mapMutableLiveData


    override fun fetchData() = viewModelScope.launch {
        setState(MapState.UnInitialized)
    }

    private fun setState(state: MapState) {
        _mapState.postValue(state)
    }

    val mapReadyCallback= OnMapReadyCallback {
        _mapMutableLiveData.value=it

    }


}