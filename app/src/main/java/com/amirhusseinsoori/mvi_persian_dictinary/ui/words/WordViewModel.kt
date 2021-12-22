package com.amirhusseinsoori.mvi_persian_dictinary.ui.words

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.lastSearch.LastSearchRepository
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WordViewModel @Inject constructor(private val wordRepository: WordRepository, val rep2: LastSearchRepository) : ViewModel() {
    private val  stateWord= MutableStateFlow(StateWord())
    val _stateWord= stateWord.asStateFlow()
    init {
        getListHistory()
    }
    fun handleEvent(handleEvent: WordEvent){
        when(handleEvent){
            is WordEvent.SearchEvent -> {
                searchWords(handleEvent.word)
            }
            WordEvent.DeleteHistoryItem ->{
                deleteHistory()
            }
        }
    }
    private fun deleteHistory(){
        viewModelScope.launch {
            rep2.deleteHistory()
        }
    }
    private fun searchWords(value :String){
        viewModelScope.launch(Dispatchers.IO) {
            stateWord.value = stateWord.value.copy(paging = wordRepository.searchWords(value) )
        }

    }
    private fun getListHistory(){
        viewModelScope.launch {
            rep2.getAllLastSearchWord().collect {
                stateWord.value=stateWord.value.copy(listHistory = it)
            }
        }
    }
}