package com.amirhusseinsoori.mvi_persian_dictinary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.amirhusseinsoori.mvi_persian_dictinary.common.utilFont
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.Word
import com.amirhusseinsoori.mvi_persian_dictinary.ui.main.MainViewModel
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.Mvi_Persian_DictinaryTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MainViewModel = hiltViewModel()
            Mvi_Persian_DictinaryTheme {
                // A surface container using the 'background' color from the theme
                viewModel._state.collectAsState().let {
                    it.value.let { data ->
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            items(data) {
                                Greeting(it)
                            }
                        }
                    }

                }

            }
        }
    }
}


@Composable
fun Greeting(list: Word) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${list.word}")
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Text(text = "${list.mean}",fontFamily = utilFont,
            fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.padding(top = 10.dp))
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Mvi_Persian_DictinaryTheme {
//        Greeting("Android")
    }
}