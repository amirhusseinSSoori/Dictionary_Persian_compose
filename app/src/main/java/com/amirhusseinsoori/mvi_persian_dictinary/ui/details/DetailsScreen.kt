package com.amirhusseinsoori.mvi_persian_dictinary.ui.details
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.amirhusseinsoori.mvi_persian_dictinary.common.utilFont
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.DicTheme
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.Neutral2
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.Neutral5



@Composable
fun Details() {
    DicTheme() {
        val viewModel: DetailsViewModel = hiltViewModel()
        viewModel._stateExample.collectAsState().let { data ->
            val paging = data.value.data
            paging.let {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Neutral2), verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    it.apply { definition?.let { items->
                            for (n in items) {
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(end = 10.dp, top = 0.dp),
                                    text = n.definition,
                                    fontFamily = utilFont,
                                    color = Neutral5,
                                    fontWeight = FontWeight.Medium,
                                    textAlign = TextAlign.End,
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                }

                }
            }


        }







}







