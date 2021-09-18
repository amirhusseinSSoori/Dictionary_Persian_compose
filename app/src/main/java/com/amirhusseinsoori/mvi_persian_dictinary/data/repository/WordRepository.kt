package com.amirhusseinsoori.mvi_persian_dictinary.data.repository

import android.graphics.Movie
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.WordsDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.Word
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WordRepository @Inject constructor(val local: WordsDao) {
//    fun allWords() :Flow<List<Word>>  =  local.getAllWord()

//    fun allWords() =
//        Pager(
//            config = PagingConfig(
//                pageSize = 20,
//                maxSize = 100,
//                enablePlaceholders = false
//            ),
//            pagingSourceFactory = { local.getAllWord() }
//        ).flow

    //
    fun allWords(): Flow<PagingData<Word>> = Pager(
        PagingConfig(
            pageSize = 20, maxSize = 100,
            enablePlaceholders = false
        )
    ) {
        local.getAllWord()
    }.flow
}


