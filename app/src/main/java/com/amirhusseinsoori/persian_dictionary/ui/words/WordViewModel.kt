package com.amirhusseinsoori.mvi_persian_dictinary.ui.words

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.amirhusseinsoori.persian_dictionary.data.db.relations.EnglishWithPersian
import com.amirhusseinsoori.persian_dictionary.data.interactor.lastSearch.LastSearchRepository
import com.amirhusseinsoori.persian_dictionary.data.interactor.word.WordRepository
import com.amirhusseinsoori.persian_dictionary.ui.base.BaseViewModel
import com.amirhusseinsoori.persian_dictionary.ui.words.WordEvent
import com.amirhusseinsoori.persian_dictionary.ui.words.WordState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WordViewModel @Inject constructor(
    private val wordRepository: WordRepository,
    private val lastSearchRepository: LastSearchRepository
) : BaseViewModel<WordEvent, WordState>() {

    init {
        handleEvent(WordEvent.ShowListWord)
    }

    override fun createInitialState(): WordState = WordState()

    override fun handleEvent(handleEvent: WordEvent) {
        when (handleEvent) {
            is WordEvent.SearchEvent -> {
                searchWords(handleEvent.word)
            }

            WordEvent.ShowListWord -> {
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

    private val _allWords: MutableStateFlow<PagingData<EnglishWithPersian>> =
        MutableStateFlow(PagingData.empty())
    val allWords = _allWords.asStateFlow()

    private fun searchWords(value: String) {
        viewModelScope.launch(Dispatchers.IO) {
            wordRepository.searchWords(value).cachedIn(viewModelScope).collect {
                _allWords.value = it
            }

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