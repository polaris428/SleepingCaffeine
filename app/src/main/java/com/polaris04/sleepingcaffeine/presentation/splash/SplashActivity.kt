package com.polaris04.sleepingcaffeine.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.polaris04.sleepingcaffeine.databinding.ActivitySplashBinding
import com.polaris04.sleepingcaffeine.presentation.BaseActivity
import com.polaris04.sleepingcaffeine.presentation.main.MainActivity
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

internal class SplashActivity : BaseActivity<SplashViewModel, ActivitySplashBinding>() {
    private val mGoogleSignInClient: GoogleSignInClient by lazy {
        GoogleSignIn.getClient(this, gso);
    }
    private var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .build()

    override val viewModel by inject<SplashViewModel>()

    override fun getViewBinding() = ActivitySplashBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mGoogleSignInClient.signOut()
            .addOnCompleteListener(this) {
                Log.d("로그아웃", "로그아웃")
            }
        binding.signInButton.setOnClickListener {
            signIn()
        }
    }

    private fun signIn(){
        val signInIntent = mGoogleSignInClient.signInIntent
        resultLauncher.launch(signInIntent)
    }

    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == -1) {
            val data: Intent? = result.data
            val task: Task<GoogleSignInAccount> =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            viewModel.viewModelScope.launch {

               viewModel.login(task)
            }

        }
    }

    override fun observeData() = viewModel.splashStateLiveData.observe(this) {
        when (it) {
            is SplashState.NonLogin -> {
                handleNonLogin()

            }
            is SplashState.LoginFail -> {
                handleNLoginFail()
            }
            is SplashState.LoginSuccess -> {
                handleLoginSuccess()
            }
        }
    }

    private fun handleNonLogin() = with(binding) {
        signInButton.isVisible = true

    }

    private fun handleNLoginFail() = with(binding) {
        signInButton.isVisible = true
    }

    private fun handleLoginSuccess() = with(binding) {
        signInButton.isGone = true
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
    }


}