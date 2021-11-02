package com.amirhusseinsoori.mvi_persian_dictinary.ui.words

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithPersian
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(val rep: WordRepository) : ViewModel() {



    val  statePersain= MutableStateFlow(StatePersain())
    val _statePersain= statePersain.asStateFlow()




    fun searchPersian(value :String){
        statePersain.value = statePersain.value.copy(paging =rep.searchWords(value) )
    }



    data class StatePersain(
        var paging: Flow<PagingData<EnglishWithPersian>> = emptyFlow(),
        var search:MutableState<String> = mutableStateOf("")
    )

}