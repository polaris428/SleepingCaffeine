package com.polaris04.sleepingcaffeine.presentation.main

sealed class MainState {
    object Home:MainState()
    object Graph:MainState()
    object User:MainState()

}