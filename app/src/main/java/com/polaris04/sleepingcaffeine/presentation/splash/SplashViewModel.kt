package com.polaris04.sleepingcaffeine.presentation.splash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.polaris04.sleepingcaffeine.domain.GoogleSignInCheckUseCase
import com.polaris04.sleepingcaffeine.domain.GoogleSignInUseCase
import com.polaris04.sleepingcaffeine.presentation.BaseViewModel
import kotlinx.coroutines.launch

internal class SplashViewModel(
    private var googleSignInUseCase: GoogleSignInCheckUseCase,
    private var googleSignInClient: GoogleSignInUseCase

) : BaseViewModel() {


    override fun fetchData() = viewModelScope.launch {
        if (googleSignInUseCase()) {
            setSplashState((SplashState.LoginSuccess))
        } else {
            setSplashState((SplashState.NonLogin))

        }



    }


    private var _splashStateLiveData = MutableLiveData<SplashState>()
    val splashStateLiveData: LiveData<SplashState> = _splashStateLiveData

    private fun setSplashState(state: SplashState) {
        _splashStateLiveData.postValue(state)
    }

    suspend fun login(task: Task<GoogleSignInAccount>)=viewModelScope.launch {
        if (googleSignInClient(task)) {
            _splashStateLiveData.postValue(SplashState.LoginSuccess)
            Log.d("성공", "성공?")
        } else {
            _splashStateLiveData.postValue(SplashState.LoginFail)
            Log.d("실패", "실패?")
        }

    }


}
