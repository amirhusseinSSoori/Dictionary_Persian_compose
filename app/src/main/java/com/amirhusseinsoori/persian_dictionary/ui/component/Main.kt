package com.amirhusseinsoori.persian_dictionary.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amirhusseinsoori.persian_dictionary.common.utilFont
import com.amirhusseinsoori.persian_dictionary.ui.theme.Violet


@Composable
fun DefineTitle(text: String, checkNull: Boolean) {
    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Violet,
        modifier = Modifier.padding(start = 20.dp),
        elevation = 10.dp
    ) {
        if (checkNull) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = text,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                fontFamily = utilFont,
                fontWeight = FontWeight.Bold
            )
        }
    }
}