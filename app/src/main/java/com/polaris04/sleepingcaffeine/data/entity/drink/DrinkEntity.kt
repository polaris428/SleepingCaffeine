package com.polaris04.sleepingcaffeine.data.entity.drink


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DrinkEntity(
    @PrimaryKey var _id: String,
    var name: String,
    var photo: String,
    var description: String,
    var caffeine: Int
)


