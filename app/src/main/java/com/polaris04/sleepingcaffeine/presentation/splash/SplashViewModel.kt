package com.polaris04.sleepingcaffeine.presentation.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.cleanarchitectureshoppingapp.data.preference.PreferenceManager
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.polaris04.sleepingcaffeine.domain.account.GoogleSignInCheckUseCase
import com.polaris04.sleepingcaffeine.domain.account.GoogleSignInUseCase
import com.polaris04.sleepingcaffeine.presentation.BaseViewModel
import kotlinx.coroutines.launch

internal class SplashViewModel(
    private var googleSignInUseCase: GoogleSignInCheckUseCase,
    private var googleSignInClient: GoogleSignInUseCase,
    private var preferenceManager: PreferenceManager

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
            preferenceManager.setString("profile",task.result.photoUrl.toString())
            preferenceManager.setString("name",task.result.familyName+task.result.givenName.toString())
        } else {
            _splashStateLiveData.postValue(SplashState.LoginFail)
        }

    }


}
