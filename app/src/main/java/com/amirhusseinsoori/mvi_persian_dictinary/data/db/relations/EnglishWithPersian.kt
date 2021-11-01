package com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations

import androidx.room.*
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.EnglishWord
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.PersianWord


data class EnglishWithPersian(
    @Embedded
    var persain: PersianWord? = null,
    @Relation(parentColumn = "idEnglishWord", entityColumn = "idEnglishWord")
    var english: List<EnglishWord>? = null)