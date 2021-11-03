package com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class DefinitionExamples (
    @PrimaryKey(autoGenerate = false)
    var idDefinitionExamples:Int,
    var idEnglishWord:Int,
    var idKindWord:Int,
    var definition:String,
    var example: String
): Parcelable