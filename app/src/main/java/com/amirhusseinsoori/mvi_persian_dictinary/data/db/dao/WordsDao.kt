package com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.paging.PagingSource
import androidx.room.Insert
import androidx.room.Transaction
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithDefinition
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithPersian
import kotlinx.coroutines.flow.Flow

@Dao
interface WordsDao {
    @Transaction
   @Query("SELECT * FROM English LEFT JOIN Persian on English.idEnglishWord=Persian.idEnglishWord where  englishWord like '%' || :msg || '%' or persianWord like '%' || :msg || '%'  group by English.idEnglishWord")
    fun searchAllWords(msg: String): PagingSource<Int, EnglishWithPersian>

    @Transaction
    @Query("SELECT * FROM English WHERE idEnglishWord = :id")
     fun exampleWords(id:Int):Flow<EnglishWithDefinition>

    @Transaction
    @Query("SELECT * FROM English LEFT JOIN Persian on English.idEnglishWord=Persian.idEnglishWord   group by English.idEnglishWord")
    fun searchAll(): List<EnglishWithPersian>




}