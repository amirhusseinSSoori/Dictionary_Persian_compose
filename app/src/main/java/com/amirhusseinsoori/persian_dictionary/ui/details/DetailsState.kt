package com.amirhusseinsoori.persian_dictionary.ui.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.amirhusseinsoori.persian_dictionary.data.db.relations.EnglishWithDefinition
import com.amirhusseinsoori.persian_dictionary.ui.base.State

data class DetailsState(
    var definition: EnglishWithDefinition = EnglishWithDefinition(),
    var persianWord: List<String>? = emptyList(),
    var search: MutableState<String> = mutableStateOf("")
) : State
