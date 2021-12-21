package com.amirhusseinsoori.mvi_persian_dictinary.ui.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.amirhusseinsoori.mvi_persian_dictinary.R
import com.amirhusseinsoori.mvi_persian_dictinary.common.previewString
import com.amirhusseinsoori.mvi_persian_dictinary.common.utilFont
import com.amirhusseinsoori.mvi_persian_dictinary.ui.component.DefineTitle
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.DicTheme
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.Neutral0


@Composable
@Preview(name = "detailsScreen")
fun DetailsScreenPreview() {
    DicTheme {
        val wordlist = listOf("عرف", "عادت", "خو", "خوی", "جامه")
        val exampleList = listOf(
            "this can develop into a bad habit",
            " a victim to a consumptive habit",
            "a boy habited as a serving lad "
        )
        val definitionList = listOf(
            "a settled or regular tendency or practice, esp. one that is hard to give up",
            " a persom bodily condition or constitution"
        )
        val scroll = rememberScrollState(0)
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
                    Column {
                        Text(
                            modifier = Modifier
                                .padding(start = 20.dp, top = 15.dp),
                            text = "habit",
                            fontFamily = utilFont,
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp
                        )

                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, top = 15.dp),
                            text = wordlist.previewString(),
                            fontFamily = utilFont,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                    Spacer(modifier = Modifier.padding(top = 25.dp))
                    DefineTitle(
                        text = stringResource(R.string.title_define_screen_definition),
                        true
                    )
                    Spacer(modifier = Modifier.padding(top = 8.dp, start = 15.dp))

                    definitionList?.let { items ->
                        items.forEach { definition ->
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
                                        text = definition,
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
                        true
                    )
                    Spacer(modifier = Modifier.padding(top = 8.dp))
                    exampleList?.let { data ->
                        data.forEach { example ->
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
                                        text = example,
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