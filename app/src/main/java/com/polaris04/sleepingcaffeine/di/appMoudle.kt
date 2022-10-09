package com.polaris04.sleepingcaffeine.di

import com.android.cleanarchitectureshoppingapp.data.preference.PreferenceManager
import com.polaris04.sleepingcaffeine.data.network.*
import com.polaris04.sleepingcaffeine.data.network.buildOkHttpClient
import com.polaris04.sleepingcaffeine.data.network.drinkApiService
import com.polaris04.sleepingcaffeine.data.network.drinkRetrofit
import com.polaris04.sleepingcaffeine.data.network.provideGsonConverterFactory
import com.polaris04.sleepingcaffeine.data.repository.account.GoogleSignRepository
import com.polaris04.sleepingcaffeine.data.repository.account.GoogleSignRepositoryInterface
import com.polaris04.sleepingcaffeine.data.repository.drink.DrinkRepository
import com.polaris04.sleepingcaffeine.data.repository.drink.DrinkRepositoryInterface
import com.polaris04.sleepingcaffeine.domain.account.GoogleSignInCheckUseCase
import com.polaris04.sleepingcaffeine.domain.account.GoogleSignInUseCase
import com.polaris04.sleepingcaffeine.domain.drink.GetDrinkListUseCase
import com.polaris04.sleepingcaffeine.presentation.caffeine_list.DrinkListViewModel
import com.polaris04.sleepingcaffeine.presentation.graph.GraphViewModel
import com.polaris04.sleepingcaffeine.presentation.home.HomeViewModel
import com.polaris04.sleepingcaffeine.presentation.main.MainViewModel
import com.polaris04.sleepingcaffeine.presentation.splash.SplashViewModel
import com.polaris04.sleepingcaffeine.presentation.user.UserViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { MainViewModel() }
    viewModel { HomeViewModel() }
    viewModel { GraphViewModel() }
    viewModel { UserViewModel() }
    viewModel { SplashViewModel(get(), get(), get()) }
    viewModel { DrinkListViewModel(get()) }

    //Coroutines Dispatcher
    single { Dispatchers.IO }
    single { Dispatchers.Main }

    factory { GoogleSignInCheckUseCase(get()) }
    factory { GoogleSignInUseCase(get()) }

    factory { GetDrinkListUseCase(get()) }


    factory<GoogleSignRepositoryInterface> { GoogleSignRepository(androidContext()) }
    factory<DrinkRepositoryInterface> { DrinkRepository(get(),get()) }

    single { PreferenceManager(androidContext()) }


    single { provideGsonConverterFactory() }
    single { buildOkHttpClient() }
    single { drinkRetrofit(get(), get()) }
    single { drinkApiService(get()) }


}