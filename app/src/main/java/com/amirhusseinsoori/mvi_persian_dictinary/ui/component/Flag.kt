package com.amirhusseinsoori.mvi_persian_dictinary.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amirhusseinsoori.mvi_persian_dictinary.common.utilFont
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.VioletBackground


@Composable
fun SetFlagCard(name:String,flag:Int) {
    Card(
        backgroundColor = VioletBackground,
        elevation = 10.dp,
    ) {
        Row(
            modifier = Modifier
                .padding(start = 4.dp, end = 4.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(flag),
                contentDescription = "",
                Modifier.size(30.dp).padding(start = 4.dp, end = 4.dp)
            )
            Text(
                modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                text = name,
                color = Color.White,
                fontFamily = utilFont,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )

        }

    }
}