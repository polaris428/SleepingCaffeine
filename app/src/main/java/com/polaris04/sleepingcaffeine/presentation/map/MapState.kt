package com.polaris04.sleepingcaffeine.presentation.map

import com.google.android.gms.maps.GoogleMap
import com.polaris04.sleepingcaffeine.R
import com.polaris04.sleepingcaffeine.presentation.graph.GraphState

sealed class MapState {
    object UnInitialized : MapState()
    data class MapSuccess(var googleMap: GoogleMap) : MapState()

}