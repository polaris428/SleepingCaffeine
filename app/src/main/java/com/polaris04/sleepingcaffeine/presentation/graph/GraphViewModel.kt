package com.polaris04.sleepingcaffeine.presentation.graph

import androidx.lifecycle.viewModelScope
import com.polaris04.sleepingcaffeine.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class GraphViewModel:BaseViewModel() {
    override fun fetchData()=viewModelScope.launch {

    }
}