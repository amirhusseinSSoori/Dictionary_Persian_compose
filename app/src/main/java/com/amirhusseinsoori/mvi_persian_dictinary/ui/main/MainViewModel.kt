package com.amirhusseinsoori.mvi_persian_dictinary.ui.main

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.Word
import com.amirhusseinsoori.mvi_persian_dictinary.data.interactor.word.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(val rep: WordRepository) :ViewModel() {
    fun searchMessage(value:String): Flow<PagingData<Word>> {
        return rep.searchWords(value)
    }
}