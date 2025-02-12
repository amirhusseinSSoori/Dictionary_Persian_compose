package com.amirhusseinsoori.persian_dictionary.data.db.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "DefinitionExamples")
data class DefinitionEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "idDefinitionExamples")
    var id: Int,
    var idEnglishWord: Int,
    var idKindWord: Int,
    var definition: String,
    var example: String
)