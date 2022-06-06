package com.amirhusseinsoori.persian_dictionary.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.amirhusseinsoori.persian_dictionary.data.db.dao.LastSearchDao
import com.amirhusseinsoori.persian_dictionary.data.db.dao.WordsDao
import com.amirhusseinsoori.persian_dictionary.data.db.entity.DefinitionEntity
import com.amirhusseinsoori.persian_dictionary.data.db.entity.EnglishEntity
import com.amirhusseinsoori.persian_dictionary.data.db.entity.LastSearchEntity
import com.amirhusseinsoori.persian_dictionary.data.db.entity.PersianEntity

@Database(
    entities = [EnglishEntity::class, PersianEntity::class,DefinitionEntity::class,LastSearchEntity::class],
    version = 1,
    )
@TypeConverters(Converters::class)
abstract class DictionaryDataBase : RoomDatabase() {
    abstract fun wordDao(): WordsDao
    abstract fun lastSearchDao(): LastSearchDao
}