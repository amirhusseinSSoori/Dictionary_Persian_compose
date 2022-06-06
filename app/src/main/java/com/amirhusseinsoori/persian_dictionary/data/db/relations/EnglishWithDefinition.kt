package com.amirhusseinsoori.persian_dictionary.data.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.amirhusseinsoori.persian_dictionary.data.db.entity.DefinitionEntity
import com.amirhusseinsoori.persian_dictionary.data.db.entity.EnglishEntity

data class EnglishWithDefinition(
    @Embedded
    var english: EnglishEntity? = null,
    @Relation(parentColumn = "idEnglishWord", entityColumn = "idEnglishWord")
    var definition: List<DefinitionEntity>? = null
)