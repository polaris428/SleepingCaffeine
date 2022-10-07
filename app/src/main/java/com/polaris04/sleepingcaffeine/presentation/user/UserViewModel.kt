package com.polaris04.sleepingcaffeine.presentation.user

import androidx.lifecycle.viewModelScope
import com.polaris04.sleepingcaffeine.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class UserViewModel :BaseViewModel(){
    override fun fetchData()=viewModelScope.launch {  }
}