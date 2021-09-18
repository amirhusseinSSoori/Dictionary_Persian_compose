package com.amirhusseinsoori.mvi_persian_dictinary.data.repository

import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.WordsDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.Word
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WordRepository @Inject constructor(val local:WordsDao) {
    fun allWords() :Flow<List<Word>>  =  local.getAllWord()
}