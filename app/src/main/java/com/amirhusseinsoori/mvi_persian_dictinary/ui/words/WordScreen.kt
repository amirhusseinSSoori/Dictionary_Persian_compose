package com.amirhusseinsoori.mvi_persian_dictinary.ui.words

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.amirhusseinsoori.mvi_persian_dictinary.common.utilFont
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.EnglishWord
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.PersianWord
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.relations.EnglishWithPersian
import com.amirhusseinsoori.mvi_persian_dictinary.ui.SearchBar
import com.amirhusseinsoori.mvi_persian_dictinary.ui.component.DicCard
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.*

@ExperimentalAnimationApi
@Composable
fun WordScreen(navigateToDetailsScreen: (id: EnglishWord) -> Unit) {
    DicTheme {
        val viewModel: MainViewModel = hiltViewModel()
        viewModel._stateWords.collectAsState().let { data ->
            val paging = data.value.paging.collectAsLazyPagingItems()
            var value by remember { data.value.search }
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                SearchBar(
                    query = value,
                    onQueryChange = {
                        value = it
                        viewModel.searchMessage(value)
                    },
                    searchFocused = true,
                    onSearchFocusChange = { },
                    onClearQuery = {
                            value = ""
                    },
                    searching = false,
                    enableClose = value != ""

                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    if(value != ""){
                        items(paging) {


                                WordItem(it!!, navigateToDetailsScreen)


                        }
                    }

                }
            }
        }

    }
}


@Composable
fun WordItem(data: EnglishWord, navigateToDetailsScreen: (id: EnglishWord) -> Unit) {


    DicCard {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navigateToDetailsScreen(data)
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()

                    .padding(start = 10.dp, top = 1.dp),
                text = data.englishWord ,fontFamily = utilFont,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, top = 0.dp),
                text = data.englishWord, fontFamily = utilFont, color = Neutral5,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.End,
                fontSize = 12.sp
            )
        }
    }
}