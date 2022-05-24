package com.amirhusseinsoori.mvi_persian_dictinary.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.LastSearchDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.WordsDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.DefinitionEntity
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.EnglishEntity
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.LastSearchEntity
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.PersianEntity

@Database(
    entities = [EnglishEntity::class, PersianEntity::class,DefinitionEntity::class,LastSearchEntity::class],
    version = 1,
    )
@TypeConverters(Converters::class)
abstract class DictionaryDataBase : RoomDatabase() {
    abstract fun wordDao(): WordsDao
    abstract fun lastSearchDao(): LastSearchDao
}