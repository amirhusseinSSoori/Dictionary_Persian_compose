package com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.WordsDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithDefinition
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithPersian
import kotlinx.coroutines.flow.Flow
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

    override fun exampleWords(id: Int): Flow<EnglishWithDefinition> {
        return local.exampleWords(id)
    }
}


