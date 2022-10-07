package com.polaris04.sleepingcaffeine.presentation.main

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.polaris04.sleepingcaffeine.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class MainViewModel : BaseViewModel() {
    override fun fetchData(): Job = viewModelScope.launch {
        if(_mainStateLiveData.value==null)
        setMainState(MainState.Home)
    }
    private var _mainStateLiveData = MutableLiveData<MainState>()
    val mainStateLiveData: LiveData<MainState> = _mainStateLiveData

    private var _fragment = MutableLiveData<Fragment>()
    val fragment: LiveData<Fragment> = _fragment

    private var _tag = MutableLiveData<String>()
    val tag: LiveData<String> = _tag

    fun setMainState(state: MainState) {
        _mainStateLiveData.postValue(state)
    }

    fun setFragment(fragment: Fragment) {
        _fragment.postValue(fragment)
    }

    fun setTag(tag: String) {
        _tag.postValue(tag)
    }
}