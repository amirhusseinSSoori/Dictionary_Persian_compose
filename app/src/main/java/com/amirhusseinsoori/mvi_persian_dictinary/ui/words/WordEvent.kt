package com.amirhusseinsoori.mvi_persian_dictinary.ui.words

sealed class WordEvent(){
    data class SearchEvent(var word:String):WordEvent()
    object DeleteHistoryItem:WordEvent()
}