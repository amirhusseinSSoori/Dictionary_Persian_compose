package com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.util.*


@Parcelize

@Entity(tableName = "English")

data class EnglishEntity constructor(
    @PrimaryKey(autoGenerate = false)
    @Json(name = "idEnglishWord")
    @ColumnInfo(name = "idEnglishWord")
    var id: Int,
    var englishWord: String,
    ) : Parcelable