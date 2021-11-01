package com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.paging.PagingSource
import androidx.room.Transaction
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.EnglishWord
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.PersianWord
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithPersian

@Dao
interface WordsDao {


//    @Query("Select * from dbo_EnglishWords where   englishWord like '%' || :msg || '%'")



    @Transaction
    @Query("Select * from dbo_EnglishWords where   englishWord like '%' || :msg || '%'")
    fun searchAllWords(msg: String): PagingSource<Int, EnglishWord>
}