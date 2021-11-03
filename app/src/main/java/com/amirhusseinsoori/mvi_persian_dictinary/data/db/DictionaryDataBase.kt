package com.amirhusseinsoori.mvi_persian_dictinary.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.WordsDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.DefinitionExamples
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.English
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.Persian

@Database(entities = [English::class,Persian::class, DefinitionExamples::class], version = 1, exportSchema = true)
abstract class DictionaryDataBase : RoomDatabase() {
    abstract fun wordDao(): WordsDao
}