package com.polaris04.sleepingcaffeine.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.cleanarchitectureshoppingapp.utilluty.DateConverter
import com.polaris04.sleepingcaffeine.data.db.dao.UserDrinkDao
import com.polaris04.sleepingcaffeine.data.entity.drink.DrinkEntity

@Database(
    entities = [DrinkEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class UserDrinkDatabase: RoomDatabase() {
    companion object{
        const val DB_NAME="UserDrinkDataBase.db"
    }
    abstract fun  userDrinkDao(): UserDrinkDao
}