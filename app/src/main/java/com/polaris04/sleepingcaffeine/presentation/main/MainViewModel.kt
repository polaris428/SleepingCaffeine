package com.polaris04.sleepingcaffeine.presentation.main

import androidx.lifecycle.viewModelScope
import com.polaris04.sleepingcaffeine.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class MainViewModel:BaseViewModel() {
    override fun fetchData(): Job =viewModelScope.launch {  }
}