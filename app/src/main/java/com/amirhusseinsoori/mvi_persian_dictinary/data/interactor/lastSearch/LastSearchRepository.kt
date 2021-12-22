package com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.lastSearch


import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.LastSearchEntity
import kotlinx.coroutines.flow.Flow

interface LastSearchRepository {
    suspend fun insert(word: LastSearchEntity)
    fun getAllLastSearchWord(): Flow<List<LastSearchEntity>>
    suspend fun deleteHistory()
}