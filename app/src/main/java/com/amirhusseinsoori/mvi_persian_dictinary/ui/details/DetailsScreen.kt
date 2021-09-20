package com.amirhusseinsoori.mvi_persian_dictinary.ui.details


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.amirhusseinsoori.mvi_persian_dictinary.common.utilFont
import com.amirhusseinsoori.mvi_persian_dictinary.ui.component.DicCard
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.DicTheme


@Composable
fun Details(word:String) {

    DicTheme() {
        DicCard(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(50.dp)
                    .background(Color(0xff00a1c7)),

                ) {
                Text(

                    modifier = Modifier.fillMaxWidth(), text = word, fontFamily = utilFont,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
                Text(

                    modifier = Modifier.fillMaxWidth(), text = word, fontFamily = utilFont,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )

            }
        }
    }


}







