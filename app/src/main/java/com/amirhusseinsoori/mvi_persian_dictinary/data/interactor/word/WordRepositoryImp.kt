package com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.WordsDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithDefinition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class WordRepositoryImp @Inject constructor(private val local: WordsDao) : WordRepository {
    override fun searchWords(msg: String) = Pager(
        PagingConfig(
            pageSize = 50, maxSize = 500,
            enablePlaceholders = false
        )
    ) {
        local.searchAllWords(msg)
    }.flow.flowOn(Dispatchers.IO)

    override fun exampleWords(id: Int): Flow<EnglishWithDefinition> {
        return local.exampleWords(id).flowOn(Dispatchers.IO)
    }
}


