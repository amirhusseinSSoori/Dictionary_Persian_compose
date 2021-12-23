package com.amirhusseinsoori.mvi_persian_dictinary.ui.words

import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.lastSearch.LastSearchRepository
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word.WordRepository
import com.amirhusseinsoori.mvi_persian_dictinary.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WordViewModel @Inject constructor(
    private val wordRepository: WordRepository,
    val lastSearchRepository: LastSearchRepository
) : BaseViewModel<WordEvent>() {
    private val stateWord = MutableStateFlow(WordState())
    val _stateWord = stateWord.asStateFlow()

    init {
        getListHistory()
    }
    override fun handleEvent(handleEvent: WordEvent) {
        when (handleEvent) {
            is WordEvent.SearchEvent -> {
                searchWords(handleEvent.word)
            }
            WordEvent.DeleteHistoryItem -> {
                deleteHistory()
            }
        }
    }

    private fun deleteHistory() {
        viewModelScope.launch {
            lastSearchRepository.deleteHistory()
        }
    }

    private fun searchWords(value: String) {
        viewModelScope.launch(Dispatchers.IO) {
            stateWord.value = stateWord.value.copy(paging = wordRepository.searchWords(value))
        }

    }

    private fun getListHistory() {
        viewModelScope.launch {
            lastSearchRepository.getAllLastSearchWord().collect {
                stateWord.value = stateWord.value.copy(listHistory = it)
            }
        }
    }


}