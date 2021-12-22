package com.amirhusseinsoori.mvi_persian_dictinary.ui.details

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.mvi_persian_dictinary.common.sendArgument
import com.amirhusseinsoori.mvi_persian_dictinary.data.MainModel
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.LastSearchEntity
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.PersianEntity
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithDefinition
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithPersian
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.lastSearch.LastSearchRepository
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word.WordRepository
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(val rep: WordRepository,   savedStateHandle: SavedStateHandle, gson:Gson,
                                           val rep2: LastSearchRepository
) : ViewModel() {
    val  stateExample= MutableStateFlow(StateExample())
    val _stateExample= stateExample.asStateFlow()



    init {
        gson.fromJson(savedStateHandle.sendArgument("details"), MainModel::class.java).apply {
            insertToHistory(
                LastSearchEntity(
                    id = id,
                    persian_word = list,
                    english_word = english
                )
            )
            handleEvent(ExampleEvent.ShowExampleWord(id))
            stateExample.value= stateExample.value.copy(persianWord = list!!)
        }





    }


    private fun handleEvent(handleEvent: ExampleEvent){
        when(handleEvent){
            is ExampleEvent.ShowExampleWord -> {
                exampleWords(handleEvent.id)
            }

        }
    }

    private fun exampleWords(id:Int) {
        viewModelScope.launch {
            rep.exampleWords(id).catch {
            }.collect {
                stateExample.value = stateExample.value.copy(definition = it)
            }
        }
    }
    private fun insertToHistory(lastSearchHistory: LastSearchEntity) {
        viewModelScope.launch {
            rep2.insert(lastSearchHistory)
        }
    }


    data class StateExample(
        var definition: EnglishWithDefinition = EnglishWithDefinition(),
        var persianWord:List<String>? = emptyList(),
        var search: MutableState<String> = mutableStateOf("")
    )


    sealed class ExampleEvent(){
        data class ShowExampleWord(var id:Int):ExampleEvent()
    }


}