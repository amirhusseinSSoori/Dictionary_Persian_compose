package com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*


@Parcelize
@Entity(tableName = "dbo_EnglishWords")
data class Word constructor(
    @PrimaryKey(autoGenerate = true)
    var idEnglishWord: Int,
    var englishWord: String


) : Parcelable