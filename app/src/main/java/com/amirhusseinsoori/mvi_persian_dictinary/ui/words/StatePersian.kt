package com.amirhusseinsoori.mvi_persian_dictinary.ui.words

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.paging.PagingData
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithPersian
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class StatePersian(
    var paging: Flow<PagingData<EnglishWithPersian>> = emptyFlow(),
    var search: MutableState<String> = mutableStateOf("")
    )