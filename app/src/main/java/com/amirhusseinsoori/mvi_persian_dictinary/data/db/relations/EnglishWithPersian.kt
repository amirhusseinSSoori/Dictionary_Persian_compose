package com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations

import androidx.room.*
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.English
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.Persian


data class EnglishWithPersian(
    @Embedded
    var english: English?=null,
    @Relation(parentColumn = "idEnglishWord", entityColumn = "idEnglishWord")
    var persian: List<Persian>?=null )