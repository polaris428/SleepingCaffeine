package com.polaris04.sleepingcaffeine.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

internal abstract class BaseViewModel :ViewModel(){
    abstract fun fetchData(): Job
}