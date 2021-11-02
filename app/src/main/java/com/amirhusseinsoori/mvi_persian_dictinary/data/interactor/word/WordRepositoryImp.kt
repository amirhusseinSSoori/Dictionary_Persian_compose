package com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.WordsDao
import javax.inject.Inject

class WordRepositoryImp @Inject constructor(val local: WordsDao):WordRepository {
    override fun searchWords(msg: String)= Pager(
        PagingConfig(
            pageSize = 100, maxSize = 1000,
            enablePlaceholders = true
        )
    ) {
        local.searchAllWords(msg)
    }.flow
}


