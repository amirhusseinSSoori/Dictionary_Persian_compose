package com.amirhusseinsoori.persian_dictionary.data.interactor.lastSearch


import com.amirhusseinsoori.persian_dictionary.data.db.entity.LastSearchEntity
import kotlinx.coroutines.flow.Flow

interface LastSearchRepository {
    suspend fun insert(word: LastSearchEntity)
    fun getAllLastSearchWord(): Flow<List<LastSearchEntity>>
    suspend fun deleteHistory()
}