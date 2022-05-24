package com.amirhusseinsoori.mvi_persian_dictinary.ui.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithDefinition
import com.amirhusseinsoori.mvi_persian_dictinary.ui.base.State

data class DetailsState(
    var definition: EnglishWithDefinition = EnglishWithDefinition(),
    var persianWord: List<String>? = emptyList(),
    var search: MutableState<String> = mutableStateOf("")
) : State
