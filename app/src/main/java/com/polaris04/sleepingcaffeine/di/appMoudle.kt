package com.polaris04.sleepingcaffeine.di
import com.android.cleanarchitectureshoppingapp.data.preference.PreferenceManager
import com.polaris04.sleepingcaffeine.data.repository.account.GoogleSignRepository
import com.polaris04.sleepingcaffeine.data.repository.account.GoogleSignRepositoryInterface
import com.polaris04.sleepingcaffeine.domain.account.GoogleSignInCheckUseCase
import com.polaris04.sleepingcaffeine.domain.account.GoogleSignInUseCase
import com.polaris04.sleepingcaffeine.presentation.caffeine_list.DrinkListViewModel
import com.polaris04.sleepingcaffeine.presentation.graph.GraphViewModel
import com.polaris04.sleepingcaffeine.presentation.home.HomeViewModel
import com.polaris04.sleepingcaffeine.presentation.main.MainViewModel
import com.polaris04.sleepingcaffeine.presentation.splash.SplashActivity
import com.polaris04.sleepingcaffeine.presentation.splash.SplashViewModel
import com.polaris04.sleepingcaffeine.presentation.user.UserViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { MainViewModel() }
    viewModel { HomeViewModel() }
    viewModel { GraphViewModel() }
    viewModel { UserViewModel() }
    viewModel { SplashViewModel(get(),get(),get()) }
    viewModel{DrinkListViewModel()}

    factory { GoogleSignInCheckUseCase(get()) }
    factory {  GoogleSignInUseCase(get()) }

    factory <GoogleSignRepositoryInterface>{ GoogleSignRepository( androidContext()) }

    single { PreferenceManager(androidContext()) }

    factory { SplashActivity() }


}