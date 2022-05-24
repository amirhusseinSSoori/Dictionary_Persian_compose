package com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.lastSearch

import com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao.LastSearchDao
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.LastSearchEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LastSearchRepositoryImp @Inject constructor(val dao: LastSearchDao) : LastSearchRepository {
    override suspend fun insert(word: LastSearchEntity) {
        dao.insert(word)
    }

    override fun getAllLastSearchWord(): Flow<List<LastSearchEntity>> {
        return dao.getAllLastSearchHistory().flowOn(Dispatchers.IO)
    }

    override suspend fun deleteHistory() = dao.delete()
}