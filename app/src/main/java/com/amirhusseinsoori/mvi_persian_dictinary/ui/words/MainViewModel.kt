package com.amirhusseinsoori.mvi_persian_dictinary.ui.words

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.Word
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(val rep: WordRepository) : ViewModel() {

    val  stateWords= MutableStateFlow(StateSearch())
    val _stateWords= stateWords.asStateFlow()



     fun searchMessage(value :String) {
         if(value!=" ".trim()){
             stateWords.value = stateWords.value.copy(paging = rep.searchWords(value))
         }

    }


    sealed class StatePaging() {
        object Idle : StatePaging()
        data class Paging(var value: String) : StatePaging()

    }


    data class StateSearch(
        var paging: Flow<PagingData<Word>> = emptyFlow(),
        var search:MutableState<String> = mutableStateOf("")

    )
}