package com.amirhusseinsoori.mvi_persian_dictinary.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.WordsDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.Word
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WordRepository @Inject constructor(val local: WordsDao) {
    fun allWords(): Flow<PagingData<Word>> = Pager(
        PagingConfig(
            pageSize = 100, maxSize = 1000,
            enablePlaceholders = true
        )
    ) {
        local.getAllWords()
    }.flow

    fun searchWords(value:String): Flow<PagingData<Word>> = Pager(
        PagingConfig(
            pageSize = 100, maxSize = 1000,
            enablePlaceholders = true
        )
    ) {
        local.searchAllWords(value)
    }.flow
}


