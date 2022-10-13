package com.polaris04.sleepingcaffeine.presentation.graph

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.polaris04.sleepingcaffeine.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class GraphViewModel:BaseViewModel() {
    private var _graphState =MutableLiveData<GraphState> (GraphState.UnInitialized)
     val graphState:LiveData<GraphState> = _graphState
    override fun fetchData()=viewModelScope.launch {
        state(GraphState.UnInitialized)
    }

    fun state(state: GraphState){
        _graphState.postValue(state)
    }


}