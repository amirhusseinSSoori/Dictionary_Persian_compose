package com.amirhusseinsoori.persian_dictionary.data.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.amirhusseinsoori.persian_dictionary.data.db.entity.EnglishEntity
import com.amirhusseinsoori.persian_dictionary.data.db.entity.PersianEntity


data class EnglishWithPersian(
    @Embedded
    var english: EnglishEntity?=null,
    @Relation(parentColumn = "idEnglishWord", entityColumn = "idEnglishWord")
    var persian: List<PersianEntity>?=null )