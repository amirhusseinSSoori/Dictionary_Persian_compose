package com.amirhusseinsoori.mvi_persian_dictinary.ui.intro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.amirhusseinsoori.mvi_persian_dictinary.common.Loader
import com.amirhusseinsoori.mvi_persian_dictinary.R


import com.amirhusseinsoori.mvi_persian_dictinary.common.utilFont


@Composable
fun Intro(){
    Column(
        modifier = Modifier
            .fillMaxSize()
             , horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Loader(R.raw.dic_anim)
        Text(text = stringResource(id = R.string.intro ),fontFamily = utilFont,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center)
    }
    
}