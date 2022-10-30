package com.android.cleanarchitectureshoppingapp.utilluty

import androidx.room.TypeConverter
import java.util.*

class DateConverter {
    @TypeConverter
    fun toData(dataLong: Long):Date?{
        return if(dataLong==null)null else Date(dataLong)
    }
    @TypeConverter
    fun fromData(date: Date):Long?{
        return date?.time
    }
}