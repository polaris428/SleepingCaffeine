package com.polaris04.sleepingcaffeine.data.db.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.DrinkEntity

interface UserDrinkDao {
    @Query("SELECT * FROM DrinkEntity")
    suspend fun getAll():List<DrinkEntity>

    @Query("SELECT * FROM DrinkEntity WHERE _id =:id")
    suspend fun getById(id:Long):DrinkEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(DrinkEntity:DrinkEntity):Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(DrinkEntityList:CaffeineDrinkEntity)

    @Query("DELETE FROM DrinkEntity WHERE _id=:id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM DrinkEntity")
    suspend fun deleteAll()

    @Update
    suspend fun update(ProductEntity: DrinkEntity)

}