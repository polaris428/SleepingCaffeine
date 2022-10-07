package com.polaris04.sleepingcaffeine.presentation.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.polaris04.sleepingcaffeine.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class HomeViewModel: BaseViewModel() {
    override fun fetchData()=viewModelScope.launch {

    }


}