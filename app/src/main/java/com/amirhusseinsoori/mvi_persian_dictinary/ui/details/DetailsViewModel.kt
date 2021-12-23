package com.amirhusseinsoori.mvi_persian_dictinary.ui.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.mvi_persian_dictinary.common.sendArgument
import com.amirhusseinsoori.mvi_persian_dictinary.data.MainModel
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.LastSearchEntity
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.lastSearch.LastSearchRepository
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word.WordRepository
import com.amirhusseinsoori.mvi_persian_dictinary.ui.base.BaseViewModel
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val wordRepository: WordRepository, savedStateHandle: SavedStateHandle, gson:Gson,
    private val lastSearchRepository: LastSearchRepository
) : BaseViewModel<DetailsEvent>() {
    private val  stateExample = MutableStateFlow(DetailsState())
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
            handleEvent(DetailsEvent.ShowExampleWord(id))
            stateExample.value= stateExample.value.copy(persianWord = list!!)
        }
    }
     override fun handleEvent(handleEvent: DetailsEvent){
        when(handleEvent){
            is DetailsEvent.ShowExampleWord -> {
                exampleWords(handleEvent.id)
            }
        }
    }

    private fun exampleWords(id:Int) {
        viewModelScope.launch {
            wordRepository.exampleWords(id).catch {
            }.collect {
                stateExample.value = stateExample.value.copy(definition = it)
            }
        }
    }
    private fun insertToHistory(lastSearchHistory: LastSearchEntity) {
        viewModelScope.launch {
            lastSearchRepository.insert(lastSearchHistory)
        }
    }


}