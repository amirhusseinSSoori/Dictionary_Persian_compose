package com.amirhusseinsoori.persian_dictionary.data

import com.amirhusseinsoori.persian_dictionary.data.db.entity.LastSearchEntity
import com.amirhusseinsoori.persian_dictionary.data.db.entity.PersianEntity
import com.amirhusseinsoori.persian_dictionary.data.db.relations.EnglishWithPersian

data class MainModel(
    var id: Int,
    var english: String,
    var list: List<String>
)


fun EnglishWithPersian.mapToMain(): MainModel {
    return MainModel(
        id = english!!.id,
        english = english!!.englishWord,
        list = persian!!.persianEntityMapToListString()
    )
}


fun List<PersianEntity>.persianEntityMapToListString(): List<String> {
    return map { it.persianWord }

}


fun LastSearchEntity.lastSearchEntityMapToMainModel(): MainModel {
    return MainModel(
        id = id,
        list = persian_word,
        english = english_word
    )
}





