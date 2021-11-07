package com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "DefinitionExamples")
data class DefinitionEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "idDefinitionExamples")
    var id:Int,
    var idEnglishWord:Int,
    var idKindWord:Int,
    var definition:String,
    var example: String
): Parcelable