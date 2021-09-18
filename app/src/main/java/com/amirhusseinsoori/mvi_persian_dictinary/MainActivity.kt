package com.amirhusseinsoori.mvi_persian_dictinary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.amirhusseinsoori.mvi_persian_dictinary.common.utilFont
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.Word
import com.amirhusseinsoori.mvi_persian_dictinary.ui.SearchBar
import com.amirhusseinsoori.mvi_persian_dictinary.ui.component.DicCard
import com.amirhusseinsoori.mvi_persian_dictinary.ui.main.MainViewModel
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.DicTheme

import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DicTheme {
                val viewModel: MainViewModel = hiltViewModel()
                var search by remember { mutableStateOf("") }
                val list = viewModel.searchMessage(search).collectAsLazyPagingItems()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    SearchBar(
                        query = search,
                        onQueryChange = { search =it},
                        searchFocused = true,
                        onSearchFocusChange = { },
                        onClearQuery = { },
                        searching = false
                    )
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        items(list) {
                            WordItem(it!!)
                        }
                    }
                }


            }
        }
    }
}
@Composable
fun WordItem(data: Word) {
    DicCard {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .padding(start = 10.dp, top = 10.dp),
                text = data.word, fontFamily = utilFont,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start
            )
        }
    }


}

