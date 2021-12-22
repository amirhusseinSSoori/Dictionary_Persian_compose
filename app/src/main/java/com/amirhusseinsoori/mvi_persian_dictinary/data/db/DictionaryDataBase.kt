package com.amirhusseinsoori.mvi_persian_dictinary.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.LastSearchDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.WordsDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.*
import com.amirhusseinsoori.mvi_persian_dictinary.data.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [EnglishEntity::class, PersianEntity::class,DefinitionEntity::class,LastSearchEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class DictionaryDataBase : RoomDatabase() {
    abstract fun wordDao(): WordsDao
    abstract fun lastSearchDao(): LastSearchDao


    class Callback @Inject constructor(
        private val database: Provider<DictionaryDataBase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)



            applicationScope.launch {
                database.get().wordDao().apply {

                }

            }
            }
        }

}