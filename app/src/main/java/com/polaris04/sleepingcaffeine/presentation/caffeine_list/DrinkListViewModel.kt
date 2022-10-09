package com.polaris04.sleepingcaffeine.presentation.caffeine_list

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.polaris04.sleepingcaffeine.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class DrinkListViewModel:BaseViewModel() {
    override fun fetchData(): Job =viewModelScope.launch {}
}