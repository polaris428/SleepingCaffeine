package com.polaris04.sleepingcaffeine.data.db.dao

import android.content.Context
import androidx.room.Room
import com.polaris04.sleepingcaffeine.data.db.UserDrinkDatabase

internal fun userDrinkDb(context: Context)=
    Room.databaseBuilder(context,UserDrinkDatabase::class.java,UserDrinkDatabase.DB_NAME).build()
    internal fun userDrinkToDoDao(database: UserDrinkDatabase)=database.userDrinkDao()