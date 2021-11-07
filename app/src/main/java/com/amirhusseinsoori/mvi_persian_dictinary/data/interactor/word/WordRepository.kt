package com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word

import androidx.paging.PagingData
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithDefinition
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithPersian
import kotlinx.coroutines.flow.Flow

interface WordRepository {
    fun searchWords(msg: String): Flow<PagingData<EnglishWithPersian>>
    fun exampleWords(id:Int):Flow<EnglishWithDefinition>

}