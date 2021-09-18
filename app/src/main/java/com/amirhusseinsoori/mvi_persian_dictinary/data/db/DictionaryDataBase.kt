package com.amirhusseinsoori.mvi_persian_dictinary.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.WordsDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.Word

@Database(entities = arrayOf(Word::class), version = 1, exportSchema = true)
//@TypeConverters(value = arrayOf(Converter::class))
abstract class DictionaryDataBase : RoomDatabase() {
    abstract fun wordDao(): WordsDao
}