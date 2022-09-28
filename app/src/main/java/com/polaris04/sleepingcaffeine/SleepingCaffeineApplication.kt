package com.polaris04.sleepingcaffeine

import android.app.Application
import com.polaris04.sleepingcaffeine.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class SleepingCaffeineApplication:Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@SleepingCaffeineApplication)
            modules(appModule)
        }
    }
}