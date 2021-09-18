package com.amirhusseinsoori.mvi_persian_dictinary.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.WordsDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.Word

@Database(entities = [Word::class], version = 1, exportSchema = true)
abstract class DictionaryDataBase : RoomDatabase() {
    abstract fun wordDao(): WordsDao
}