package com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Persian (
    @PrimaryKey(autoGenerate = true)
    var idPersianWord: Int,
    var idEnglishWord: Int,
    var idKindWord:Int,
    var persianWord:String,
): Parcelable