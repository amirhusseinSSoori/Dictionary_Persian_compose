package com.amirhusseinsoori.mvi_persian_dictinary.data.di

import android.content.Context
import androidx.room.Room
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.DictionaryDataBase
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.WordsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideDicDb(
        @ApplicationContext context: Context,
    ): DictionaryDataBase {

        return Room
            .databaseBuilder(
                context,
                DictionaryDataBase::class.java,
                "my_database"
            )
            .fallbackToDestructiveMigration()
            .createFromAsset("my_database")
            .build()
    }

    @Provides
    fun provideWordDao(db:DictionaryDataBase):WordsDao = db.wordDao()
}