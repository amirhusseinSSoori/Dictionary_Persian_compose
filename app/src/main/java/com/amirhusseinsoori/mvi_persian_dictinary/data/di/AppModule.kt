package com.amirhusseinsoori.mvi_persian_dictinary.data.di

import android.content.Context
import androidx.room.Room
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.DictionaryDataBase
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.WordsDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word.WordRepository
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word.WordRepositoryImp
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
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
        @ApplicationContext context: Context,
         callback: DictionaryDataBase.Callback
    ): DictionaryDataBase {

        return Room
            .databaseBuilder(
                context,
                DictionaryDataBase::class.java,
                "dbEnglishWords"
            )
//            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .createFromAsset("dbEnglishWords")
            .build()
    }

    @Provides
    fun provideWordDao(db:DictionaryDataBase):WordsDao = db.wordDao()

    @Provides
    fun provideWordRepository(local: WordsDao):WordRepository{
        return WordRepositoryImp(local)
    }
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }


    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope