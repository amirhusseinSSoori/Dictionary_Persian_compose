package com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.WordsDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.Word
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WordRepositoryImp @Inject constructor(val local: WordsDao):WordRepository {
    override fun searchWords(value: String): Flow<PagingData<Word>> = Pager(
        PagingConfig(
            pageSize = 100, maxSize = 1000,
            enablePlaceholders = false
        )
    ) {
        local.searchAllWords(value)
    }.flow
}


