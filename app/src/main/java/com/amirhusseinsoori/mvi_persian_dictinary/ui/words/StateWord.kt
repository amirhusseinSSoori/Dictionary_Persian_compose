package com.amirhusseinsoori.mvi_persian_dictinary.ui.words

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.paging.PagingData
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.LastSearchEntity
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithPersian
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class StateWord(
    var paging: Flow<PagingData<EnglishWithPersian>> = emptyFlow(),
    var listHistory: List<LastSearchEntity> = emptyList(),
    var search: MutableState<String> = mutableStateOf("")
    )