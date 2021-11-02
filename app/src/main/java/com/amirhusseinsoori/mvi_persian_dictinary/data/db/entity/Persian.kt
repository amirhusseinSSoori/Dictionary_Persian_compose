package com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity

import android.os.Parcelable
import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Persian (
    @PrimaryKey(autoGenerate = true)
    var idPersianWord: Int,
    var idEnglishWord: Int,
    var idKindWord:Int,
    @ColumnInfo(index = true)
    var persianWord:String,
): Parcelable