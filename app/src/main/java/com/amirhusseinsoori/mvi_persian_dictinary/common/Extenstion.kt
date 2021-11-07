package com.amirhusseinsoori.mvi_persian_dictinary.common

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.SavedStateHandle
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.DefinitionEntity
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.EnglishEntity
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.PersianEntity


fun<T> SavedStateHandle.sendArgument(data:T):T{
   get<T>(data.toString()).let {
      return it!!
  }
}

fun ArrayList<PersianEntity>.persianString():String{
    val sb = StringBuilder()
    this.forEach{ sb.append(it.persianWord + " , ") }
    return sb.toString().dropLast(2) }

@Composable
public fun BackHandler(enabled: Boolean = true, onBack: () -> Unit) {
    // Safely update the current `onBack` lambda when a new one is provided
    val currentOnBack by rememberUpdatedState(onBack)
    // Remember in Composition a back callback that calls the `onBack` lambda
    val backCallback = remember {
        object : OnBackPressedCallback(enabled) {
            override fun handleOnBackPressed() {
                currentOnBack()
            }
        }
    }
    // On every successful composition, update the callback with the `enabled` value
    SideEffect {
        backCallback.isEnabled = enabled
    }
    val backDispatcher = checkNotNull(LocalOnBackPressedDispatcherOwner.current) {
        "No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner"
    }.onBackPressedDispatcher
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner, backDispatcher) {
        // Add callback to the backDispatcher
        backDispatcher.addCallback(lifecycleOwner, backCallback)
        // When the effect leaves the Composition, remove the callback
        onDispose {
            backCallback.remove()
        }
    }
}


