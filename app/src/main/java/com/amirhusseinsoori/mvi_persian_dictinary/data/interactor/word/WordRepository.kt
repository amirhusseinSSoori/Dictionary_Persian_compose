package com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word

import androidx.paging.PagingData
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.Word
import kotlinx.coroutines.flow.Flow

interface WordRepository {
    fun searchWords(value:String): Flow<PagingData<Word>>
}