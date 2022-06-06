package com.amirhusseinsoori.persian_dictionary.ui.words

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.paging.PagingData
import com.amirhusseinsoori.persian_dictionary.data.db.entity.LastSearchEntity
import com.amirhusseinsoori.persian_dictionary.data.db.relations.EnglishWithPersian
import com.amirhusseinsoori.persian_dictionary.ui.base.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class WordState(
    var paging: Flow<PagingData<EnglishWithPersian>> = emptyFlow(),
    var listHistory: List<LastSearchEntity> = emptyList(),
    var search: MutableState<String> = mutableStateOf("")
) : State