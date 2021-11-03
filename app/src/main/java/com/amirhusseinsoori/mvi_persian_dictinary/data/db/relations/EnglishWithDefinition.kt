package com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.DefinitionExamples
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.English
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.Persian

data class EnglishWithDefinition (
    @Embedded
    var english: English?=null,
    @Relation(parentColumn = "idEnglishWord", entityColumn = "idEnglishWord")
    var definition: List<DefinitionExamples>?=null
        )