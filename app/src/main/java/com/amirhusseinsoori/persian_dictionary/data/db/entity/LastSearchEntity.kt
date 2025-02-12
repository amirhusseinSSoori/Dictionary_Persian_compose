package com.amirhusseinsoori.persian_dictionary.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "dbo_history_word")
data class LastSearchEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_english_word")
    val id: Int,
    var sort: Long = Date().time,
    val english_word: String,
    val persian_word: List<String>
)