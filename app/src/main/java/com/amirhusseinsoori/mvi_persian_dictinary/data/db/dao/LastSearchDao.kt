package com.amirhusseinsoori.mvi_persian_dictinary.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.LastSearchEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface LastSearchDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(word: LastSearchEntity)

    @Query("SELECT * From dbo_history_word   Order by sort desc limit 20")
    fun getAllLastSearchHistory(): Flow<List<LastSearchEntity>>

    @Query("DELETE  FROM dbo_history_word")
    suspend fun delete()
}