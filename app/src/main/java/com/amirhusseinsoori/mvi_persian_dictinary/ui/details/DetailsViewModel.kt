package com.amirhusseinsoori.mvi_persian_dictinary.ui.details

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.mvi_persian_dictinary.common.sendArgument
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.English
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithDefinition
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word.WordRepository
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(val rep: WordRepository,   savedStateHandle: SavedStateHandle, gson:Gson) : ViewModel() {
    val  stateExample= MutableStateFlow(StateExample())
    val _stateExample= stateExample.asStateFlow()

    init {
        exampleWords(gson.fromJson(savedStateHandle.sendArgument("details"), English::class.java).idEnglishWord)
    }

    private fun exampleWords(id:Int){
        viewModelScope.launch {
            rep.exampleWords(id).catch {
                Log.e("TAG", "example: ${it.message}", )
            }.collect {
                stateExample.value=stateExample.value.copy(data=it)
            }
        }
    }

    data class StateExample(
        var data: EnglishWithDefinition = EnglishWithDefinition(),
        var search: MutableState<String> = mutableStateOf("")
    )
}