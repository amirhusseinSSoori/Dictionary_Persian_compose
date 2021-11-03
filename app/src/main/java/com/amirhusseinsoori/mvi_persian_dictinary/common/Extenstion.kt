package com.amirhusseinsoori.mvi_persian_dictinary.common

import androidx.lifecycle.SavedStateHandle
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.English
import com.google.gson.Gson




fun<T> SavedStateHandle.sendArgument(data:T):T{
   get<T>(data.toString()).let {
      return it!!
  }
}



