package com.amirhusseinsoori.mvi_persian_dictinary.ui.words

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithPersian
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WordViewModel @Inject constructor(private val rep: WordRepository) : ViewModel() {

    val  statePersain= MutableStateFlow(StatePersian())
    val _statePersain= statePersain.asStateFlow()

    fun searchWords(value :String){
        viewModelScope.launch(Dispatchers.IO) {
            statePersain.value = statePersain.value.copy(paging = rep.searchWords(value) )
        }

    }

}