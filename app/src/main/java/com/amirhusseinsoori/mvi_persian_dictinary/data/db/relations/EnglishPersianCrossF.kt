package com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations

import androidx.room.Entity

@Entity(primaryKeys = ["idEnglishWord", "idPersianWord"])
data class EnglishPersianCrossF(
    val idEnglishWord: Int,
    val idPersianWord: Int
)
