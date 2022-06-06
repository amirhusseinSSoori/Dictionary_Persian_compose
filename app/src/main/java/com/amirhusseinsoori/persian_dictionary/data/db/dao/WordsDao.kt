package com.amirhusseinsoori.persian_dictionary.data.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.amirhusseinsoori.persian_dictionary.data.db.relations.EnglishWithDefinition
import com.amirhusseinsoori.persian_dictionary.data.db.relations.EnglishWithPersian
import kotlinx.coroutines.flow.Flow

@Dao
interface WordsDao {
    @Transaction
    @Query("SELECT * FROM English  where  englishWord like  :msg || '%'   group by englishWord  limit 50")
    fun searchAllWords(msg: String): PagingSource<Int, EnglishWithPersian>

    @Transaction
    @Query("SELECT * FROM English WHERE idEnglishWord = :id")
    fun exampleWords(id: Int): Flow<EnglishWithDefinition>
}