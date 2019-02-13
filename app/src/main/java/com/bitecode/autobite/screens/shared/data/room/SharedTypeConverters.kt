package com.bitecode.autobite.screens.shared.data.room

import androidx.room.TypeConverter
import org.threeten.bp.LocalDateTime

class SharedTypeConverters {

    @TypeConverter
    fun fromLocalDateTimeToString(dt: LocalDateTime): String = dt.toString()

    @TypeConverter
    fun fromStringToLocalDateTime(st: String): LocalDateTime = LocalDateTime.parse(st)
}