package com.amirhusseinsoori.persian_dictionary.ui.words

import com.amirhusseinsoori.persian_dictionary.ui.base.Event

sealed class WordEvent() : Event {
    data class SearchEvent(var word: String) : WordEvent()
    object ShowListWord : WordEvent()
    object DeleteHistoryItem : WordEvent()
}