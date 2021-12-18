package com.amirhusseinsoori.mvi_persian_dictinary.ui.words

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.amirhusseinsoori.mvi_persian_dictinary.R
import com.amirhusseinsoori.mvi_persian_dictinary.common.persianString
import com.amirhusseinsoori.mvi_persian_dictinary.common.utilFont
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.PersianEntity
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithPersian
import com.amirhusseinsoori.mvi_persian_dictinary.ui.SearchBar

import com.amirhusseinsoori.mvi_persian_dictinary.ui.component.DicCard
import com.amirhusseinsoori.mvi_persian_dictinary.ui.component.SetFlagCard
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.*

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun WordScreen(navigateToDetailsScreen: (id: EnglishWithPersian) -> Unit) {

    DicTheme {
        val viewModel: WordViewModel = hiltViewModel()
        viewModel._statePersain.collectAsState().let { data ->
            val paging = data.value.paging.collectAsLazyPagingItems()
            var value by rememberSaveable { mutableStateOf("") }

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Neutral0)
            ) {
                Card(
                    shape = RoundedCornerShape(40.dp),
                    backgroundColor = Violet,
                    elevation = 10.dp,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 20.dp, top = 50.dp, bottom = 80.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 80.dp),
                            text = stringResource(R.string.app_name),
                            color = Color.White,
                            fontFamily = utilFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 35.sp,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 15.dp),
                            text = stringResource(R.string.title_second_app_name),
                            color = Color.White,
                            fontFamily = utilFont,
                            fontWeight = FontWeight.Medium,
                            fontSize = 11.sp,
                            textAlign = TextAlign.Center
                        )

                        Row(
                            modifier = Modifier
                                .padding(15.dp), horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            SetFlagCard("English", R.drawable.en_flag)
                            SetFlagCard("Persian", R.drawable.ir_flag)
                        }

                        SearchBar(
                            query = value,
                            onQueryChange = {
                                value = it
                                viewModel.searchWords(value)

                            },
                            onSearchFocusChange = { },
                            onClearQuery = {
                                value = ""
                            },
                            enableClose = value != "",
                        )
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            items(paging) {
                                WordItem(it!!, navigateToDetailsScreen)
                            }
                        }
                    }

                }
            }
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun WordItem(
    data: EnglishWithPersian,
    navigateToDetailsScreen: (id: EnglishWithPersian) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .clickable {
                navigateToDetailsScreen(data)

            }
            .background(Neutral0, shape = RoundedCornerShape(20.dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 5.dp),
            text = data.english!!.englishWord, fontFamily = utilFont,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Start

        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 15.dp, bottom = 8.dp),
            text = (data.persian as ArrayList<PersianEntity>).persianString(),
            fontFamily = utilFont,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.End,
            color = DicTheme.colors.textHelp,
            fontSize = 12.sp

        )
    }

}





