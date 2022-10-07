package com.polaris04.sleepingcaffeine.presentation.splash

sealed class SplashState {
    object NonLogin:SplashState()
    object LoginSuccess:SplashState()
    object LoginFail:SplashState()
}