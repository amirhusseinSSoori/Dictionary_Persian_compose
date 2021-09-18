package com.amirhusseinsoori.mvi_persian_dictinary.ui.main

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.Word
import com.amirhusseinsoori.mvi_persian_dictinary.data.repository.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(val rep: WordRepository) :ViewModel() {


    var state= MutableStateFlow<List<Word>>(emptyList())
    val _state=state.asStateFlow()


    init {
        subscriber()
    }






    fun subscriber(){
        viewModelScope.launch {
            rep.allWords().collect {
                state.value = it
            }
        }
    }





}