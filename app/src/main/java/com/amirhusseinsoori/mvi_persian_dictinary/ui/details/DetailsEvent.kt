package com.amirhusseinsoori.mvi_persian_dictinary.ui.details

import com.amirhusseinsoori.mvi_persian_dictinary.ui.base.Event

sealed class DetailsEvent():Event{
    data class ShowExampleWord(var id:Int):DetailsEvent()
}
