package com.polaris04.sleepingcaffeine.di

import com.polaris04.sleepingcaffeine.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule= module {

    viewModel { MainViewModel() }
}