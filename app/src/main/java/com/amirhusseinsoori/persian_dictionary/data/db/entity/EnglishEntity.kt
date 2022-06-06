package com.amirhusseinsoori.persian_dictionary.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "English")
data class EnglishEntity constructor(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "idEnglishWord")
    var id: Int,
    var englishWord: String,
    ) : Parcelable