package com.amirhusseinsoori.persian_dictionary.ui.words

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.amirhusseinsoori.persian_dictionary.data.db.entity.LastSearchEntity
import com.amirhusseinsoori.persian_dictionary.data.db.relations.EnglishWithPersian
import com.amirhusseinsoori.persian_dictionary.data.interactor.lastSearch.LastSearchRepository
import com.amirhusseinsoori.persian_dictionary.data.interactor.word.WordRepository
import com.amirhusseinsoori.persian_dictionary.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WordViewModel @Inject constructor(
    private val wordRepository: WordRepository,
    private val lastSearchRepository: LastSearchRepository
) : ViewModel() {

    init {
        handleEvent(WordEvent.ShowListWord)
    }
    val _pagingData: MutableStateFlow<PagingData<EnglishWithPersian>> = MutableStateFlow(PagingData.empty())
    val pagingData = _pagingData.asStateFlow()

    val _lastHistory: MutableStateFlow<List<LastSearchEntity>> = MutableStateFlow(emptyList())
    val lastHistory = _lastHistory.asStateFlow()


     fun createInitialState(): WordState = WordState()

     fun handleEvent(handleEvent: WordEvent) {
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

    private fun searchWords(value: String) {
        viewModelScope.launch(Dispatchers.IO) {
            wordRepository.searchWords(value).cachedIn(viewModelScope).collect{
                _pagingData.value =it
            }

        }

    }

    private fun getListHistory() {
        viewModelScope.launch {
            lastSearchRepository.getAllLastSearchWord().collect {
                _lastHistory.value =  it
            }
        }
    }


}