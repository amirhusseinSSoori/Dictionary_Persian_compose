package com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word

import androidx.paging.PagingData
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.English
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithPersian
import kotlinx.coroutines.flow.Flow

interface WordRepository {
    fun searchWords(value:String): Flow<PagingData<English>>
    fun searchPersian(msg: String): Flow<PagingData<EnglishWithPersian>>
}