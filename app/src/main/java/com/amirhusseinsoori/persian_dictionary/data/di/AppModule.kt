package com.amirhusseinsoori.persian_dictionary.data.di

import android.content.Context
import androidx.room.Room
import com.amirhusseinsoori.persian_dictionary.data.db.DictionaryDataBase
import com.amirhusseinsoori.persian_dictionary.data.db.dao.LastSearchDao
import com.amirhusseinsoori.persian_dictionary.data.db.dao.WordsDao
import com.amirhusseinsoori.persian_dictionary.data.interactor.lastSearch.LastSearchRepository
import com.amirhusseinsoori.persian_dictionary.data.interactor.lastSearch.LastSearchRepositoryImp
import com.amirhusseinsoori.persian_dictionary.data.interactor.word.WordRepository
import com.amirhusseinsoori.persian_dictionary.data.interactor.word.WordRepositoryImp
import com.google.gson.Gson
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
        @ApplicationContext context: Context
    ): DictionaryDataBase {
        return Room
            .databaseBuilder(
                context,
                DictionaryDataBase::class.java,
                "dbEnglishWords"
            )
            .createFromAsset("dbEnglishWords")
            .build()
    }

    @Provides
    fun provideWordDao(db: DictionaryDataBase): WordsDao = db.wordDao()

    @Provides
    fun provideLastSearchDao(db: DictionaryDataBase): LastSearchDao = db.lastSearchDao()

    @Provides
    fun provideWordRepository(local: WordsDao): WordRepository {
        return WordRepositoryImp(local)
    }

    @Provides
    fun provideLastRepository(local: LastSearchDao): LastSearchRepository {
        return LastSearchRepositoryImp(local)
    }

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

}

