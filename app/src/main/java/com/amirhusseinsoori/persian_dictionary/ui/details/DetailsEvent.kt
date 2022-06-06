package com.amirhusseinsoori.persian_dictionary.ui.details

import com.amirhusseinsoori.persian_dictionary.ui.base.Event

sealed class DetailsEvent() : Event {
    data class ShowExampleWord(var id: Int) : DetailsEvent()
    data class InsertToHistory(var id: Int, var listWord: List<String>, var english: String) :
        DetailsEvent()
}
