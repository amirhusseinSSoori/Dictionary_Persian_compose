package com.amirhusseinsoori.mvi_persian_dictinary.ui.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<event: Event> :ViewModel() {
    abstract fun handleEvent(handleEvent:event)
}