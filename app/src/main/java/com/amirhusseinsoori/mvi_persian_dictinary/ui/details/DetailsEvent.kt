package com.amirhusseinsoori.mvi_persian_dictinary.ui.details

sealed class DetailsEvent(){
    data class ShowExampleWord(var id:Int):DetailsEvent()
}
