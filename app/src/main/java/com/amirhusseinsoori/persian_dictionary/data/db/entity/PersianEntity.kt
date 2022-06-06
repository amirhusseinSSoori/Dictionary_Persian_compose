package com.amirhusseinsoori.persian_dictionary.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Persian")
data class PersianEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "idPersianWord")
    var id: Int,
    @ColumnInfo(name = "idEnglishWord")
    var idEnglishWord: Int,
    var idKindWord:Int,
    @ColumnInfo(index = true)
    var persianWord:String,
): Parcelable