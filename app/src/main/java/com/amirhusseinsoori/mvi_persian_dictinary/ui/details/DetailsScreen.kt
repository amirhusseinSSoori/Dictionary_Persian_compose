package com.amirhusseinsoori.mvi_persian_dictinary.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.amirhusseinsoori.mvi_persian_dictinary.common.persianString
import com.amirhusseinsoori.mvi_persian_dictinary.common.utilFont
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.PersianEntity
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.DicTheme
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.Neutral2
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.Neutral5


@Composable
fun Details() {
    DicTheme {
        val scroll = rememberScrollState(0)
        val viewModel: DetailsViewModel = hiltViewModel()
        viewModel._stateExample.collectAsState().let { data ->
            val paging = data.value.definition
            val per = data.value.persianWord
            paging.let {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Neutral2)
                        .verticalScroll(scroll),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    it.apply {


                        english?.let {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 30.dp),
                                text = it.englishWord,
                                fontFamily = utilFont,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                fontSize = 17.sp
                            )
                        }
                        per?.let {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 25.dp),
                                text = it.persianString(),
                                fontFamily = utilFont,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Right,
                                fontSize = 15.sp
                            )
                        }

                        Spacer(modifier = Modifier.padding(top = 25.dp))
                        Text(text = "definition", textAlign = TextAlign.Center, fontSize = 20.sp)

                        Spacer(modifier = Modifier.padding(top = 35.dp, start = 15.dp))
                        definition?.let { items ->
                            items.forEach { n ->
                                Card(
                                    shape = RoundedCornerShape(3.dp),
                                    backgroundColor = Color.LightGray,
                                    elevation = 12.dp, modifier = Modifier.padding(10.dp)
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(end = 10.dp, top = 10.dp, bottom = 10.dp, start = 15.dp),
                                        text = n.definition,
                                        fontFamily = utilFont,
                                        fontWeight = FontWeight.Medium,
                                        textAlign = TextAlign.Left,
                                        fontSize = 20.sp
                                    )
                                }
                            }

                        }
                        Spacer(modifier = Modifier.padding(top = 35.dp))
                        Text(text = "Example", textAlign = TextAlign.Center, fontSize = 20.sp)

                        Spacer(modifier = Modifier.padding(top = 20.dp))
                        definition?.let { items ->
                            items.forEach { n ->
                                Card(
                                    shape = RoundedCornerShape(15.dp),
                                    backgroundColor = Color.White,
                                    elevation = 5.dp, modifier = Modifier.padding(10.dp)
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(end = 10.dp, top = 10.dp, bottom = 10.dp, start = 15.dp),
                                        text = n.example,
                                        fontFamily = utilFont,
                                        fontWeight = FontWeight.Medium,
                                        textAlign = TextAlign.Left,
                                        fontSize = 18.sp
                                    )
                                }
                            }

                        }
                    }
                }


            }


        }
    }


}








