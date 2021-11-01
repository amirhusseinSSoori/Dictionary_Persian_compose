package com.amirhusseinsoori.mvi_persian_dictinary.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.WordsDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.EnglishWord
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.PersianWord
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishPersianCrossF
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithPersian

@Database(entities = [EnglishWord::class,PersianWord::class], version = 1, exportSchema = true)
abstract class DictionaryDataBase : RoomDatabase() {
    abstract fun wordDao(): WordsDao
}