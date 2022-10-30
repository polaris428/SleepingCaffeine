package com.polaris04.sleepingcaffeine.data.db.dao

import androidx.room.*
import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.DrinkEntity
@Dao
interface UserDrinkDao {
    @Query("SELECT * FROM DrinkEntity")
    suspend fun getAll():List<DrinkEntity>

    @Query("SELECT * FROM DrinkEntity WHERE _id =:id")
    suspend fun getById(id:Long):DrinkEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(DrinkEntity:DrinkEntity):Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(DrinkEntity:List<DrinkEntity>)

    @Query("DELETE FROM DrinkEntity WHERE _id=:id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM DrinkEntity")
    suspend fun deleteAll()

    @Update
    suspend fun update(ProductEntity: DrinkEntity)

}