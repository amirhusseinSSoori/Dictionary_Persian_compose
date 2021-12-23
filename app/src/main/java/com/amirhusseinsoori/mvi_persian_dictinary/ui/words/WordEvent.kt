package com.amirhusseinsoori.mvi_persian_dictinary.ui.words

import com.amirhusseinsoori.mvi_persian_dictinary.ui.base.Event

sealed class WordEvent(): Event {
    data class SearchEvent(var word:String):WordEvent()
    object DeleteHistoryItem:WordEvent()
}