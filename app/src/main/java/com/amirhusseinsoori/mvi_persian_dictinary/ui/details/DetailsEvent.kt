package com.amirhusseinsoori.mvi_persian_dictinary.ui.details

import com.amirhusseinsoori.mvi_persian_dictinary.ui.base.Event

sealed class DetailsEvent():Event{
    data class ShowExampleWord(var id:Int):DetailsEvent()
    data class InsertToHistory(var id:Int,var listWord:List<String>,var english:String):DetailsEvent()
}
