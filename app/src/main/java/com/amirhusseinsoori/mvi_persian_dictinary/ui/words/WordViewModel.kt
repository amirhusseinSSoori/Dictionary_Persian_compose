package com.amirhusseinsoori.mvi_persian_dictinary.ui.words

import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.lastSearch.LastSearchRepository
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word.WordRepository
import com.amirhusseinsoori.mvi_persian_dictinary.ui.base.BaseViewModel
import com.amirhusseinsoori.mvi_persian_dictinary.ui.base.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WordViewModel @Inject constructor(
    private val wordRepository: WordRepository,
    private val lastSearchRepository: LastSearchRepository
) : BaseViewModel<WordEvent,WordState>() {

    init {
      handleEvent(WordEvent.ShowListWord)
    }

    override fun createInitialState(): WordState  = WordState()

    override fun handleEvent(handleEvent: WordEvent) {
        when (handleEvent) {
            is WordEvent.SearchEvent -> {
                searchWords(handleEvent.word)
            }
            WordEvent.ShowListWord ->{
                getListHistory()
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
            state.value = state.value.copy(paging = wordRepository.searchWords(value))
        }

    }

    private fun getListHistory() {
        viewModelScope.launch {
            lastSearchRepository.getAllLastSearchWord().collect {
                state.value = state.value.copy(listHistory = it)
            }
        }
    }




}