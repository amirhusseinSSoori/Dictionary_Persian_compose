package com.amirhusseinsoori.mvi_persian_dictinary.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.amirhusseinsoori.mvi_persian_dictinary.R
import com.amirhusseinsoori.mvi_persian_dictinary.common.previewString
import com.amirhusseinsoori.mvi_persian_dictinary.common.utilFont
import com.amirhusseinsoori.mvi_persian_dictinary.ui.component.DefineTitle
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.*


@Composable
fun Details() {
    DicTheme {
        val scroll = rememberScrollState(0)
        var checkNullAble by rememberSaveable { mutableStateOf(true) }
        val viewModel: DetailsViewModel = hiltViewModel()
        viewModel._stateExample.collectAsState().let { data ->
            val paging = data.value.definition
            val per = data.value.persianWord
            paging.let {
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Neutral0)

                ) {
                    Card(
                        shape = RoundedCornerShape(40.dp),
                        backgroundColor = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp, end = 20.dp, top = 50.dp, bottom = 80.dp),
                        elevation = 10.dp
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(20.dp)
                                .background(Color.White, shape = RoundedCornerShape(40.dp))
                                .fillMaxSize()
                                .verticalScroll(scroll)
                        ) {
                            it.apply {
                                Column {
                                        english?.let {
                                            Text(
                                                modifier = Modifier
                                                    .padding(start = 20.dp, top = 15.dp),
                                                text = it.englishWord,
                                                fontFamily = utilFont,
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 17.sp
                                            )
                                        }
                                        per?.let {
                                            Text(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(start = 20.dp, top = 15.dp),
                                                text = it.previewString(),
                                                fontFamily = utilFont,
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 15.sp
                                            )
                                        }
                                    }

                                Spacer(modifier = Modifier.padding(top = 25.dp))
                                DefineTitle(
                                    text = stringResource(R.string.title_define_screen_definition),
                                    checkNullAble
                                )
                                Spacer(modifier = Modifier.padding(top = 8.dp, start = 15.dp))
                                definition?.let { def ->
                                    if (def.isEmpty()) {
                                        checkNullAble = false
                                    }
                                    def.forEach { n ->
                                        Card(
                                            shape = RoundedCornerShape(10.dp),
                                            backgroundColor = Neutral0,
                                            modifier = Modifier.padding(10.dp),
                                            elevation = 10.dp
                                        ) {
                                            SelectionContainer() {
                                                Text(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(
                                                            end = 5.dp,
                                                            top = 5.dp,
                                                            bottom = 5.dp,
                                                            start = 30.dp
                                                        ),
                                                    text = n.definition,
                                                    fontFamily = utilFont,
                                                    fontWeight = FontWeight.Medium,
                                                    textAlign = TextAlign.Left,
                                                    color = Color.Black,
                                                    fontSize = 18.sp
                                                )
                                            }
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.padding(top = 35.dp))
                                DefineTitle(
                                    text = stringResource(R.string.title_define_screen_example),
                                    checkNullAble
                                )
                                Spacer(modifier = Modifier.padding(top = 8.dp))
                                definition?.let { items ->
                                    items.forEach { n ->
                                        Card(
                                            shape = RoundedCornerShape(10.dp),
                                            backgroundColor = Neutral0,
                                            modifier = Modifier.padding(10.dp),
                                            elevation = 10.dp
                                        ) {
                                            SelectionContainer() {
                                                Text(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(
                                                            end = 5.dp,
                                                            top = 5.dp,
                                                            bottom = 5.dp,
                                                            start = 30.dp
                                                        ),
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
        }
    }
}