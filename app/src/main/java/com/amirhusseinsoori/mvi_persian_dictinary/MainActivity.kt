package com.amirhusseinsoori.mvi_persian_dictinary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.tooling.preview.Preview
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.Mvi_Persian_DictinaryTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mvi_Persian_DictinaryTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}
@Immutable
data class Ali(val name:String)

@Composable
fun Greeting(name: String) {
    var a=Ali("hussein")

    Text(text = "Hello $name!" +a.name)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Mvi_Persian_DictinaryTheme {
        Greeting("Android")
    }
}