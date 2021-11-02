package com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.paging.PagingSource
import androidx.room.Transaction
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.English
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithPersian
import kotlinx.coroutines.flow.Flow

@Dao
interface WordsDao {


//    @Query("SELECT * FROM English where englishWord like '%' || :msg || '%'")
//@Query("SELECT    * FROM   English INNER JOIN Persian ON English.idEnglishWord = Persian.idEnglishWord  where  englishWord like '%' || :msg || '%'  ")

//    @Query("select * from English  where idEnglishWord in (select distinct(idEnglishWord) from persian  ) and  englishWord   like '%' || :msg || '%'")
    @Transaction
    @Query("SELECT * FROM English INNER JOIN Persian on English.idEnglishWord=Persian.idEnglishWord where  englishWord like '%' || :msg || '%' or persianWord like '%' || :msg || '%'  group by English.idEnglishWord")
    fun searchAllWords(msg: String): PagingSource<Int, EnglishWithPersian>
}