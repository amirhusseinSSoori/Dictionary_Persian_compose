package com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.EnglishEntity
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.PersianEntity


data class EnglishWithPersian(
    @Embedded
    var english: EnglishEntity?=null,
    @Relation(parentColumn = "idEnglishWord", entityColumn = "idEnglishWord")
    var persian: List<PersianEntity>?=null )