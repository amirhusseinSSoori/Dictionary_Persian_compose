package com.amirhusseinsoori.mvi_persian_dictinary.data.di

import android.content.Context
import androidx.room.Room
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.DictionaryDataBase
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.LastSearchDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.WordsDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.lastSearch.LastSearchRepository
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word.WordRepository
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word.WordRepositoryImp
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.lastSearch.LastSearchRepositoryImp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
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

