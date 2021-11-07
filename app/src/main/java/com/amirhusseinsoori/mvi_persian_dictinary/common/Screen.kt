package com.amirhusseinsoori.mvi_persian_dictinary.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.amirhusseinsoori.mvi_persian_dictinary.R
import com.google.accompanist.insets.LocalWindowInsets

val utilFont = FontFamily(
    Font(R.font.domine_bold, FontWeight.Light),
    Font(R.font.domine_regular, FontWeight.Normal),
    Font(R.font.montserrat_medium, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.iransanse_medium, FontWeight.Medium),
    Font(R.font.montserrat_semibold, FontWeight.Bold)
)

@Composable
fun Loader(anim:Int) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(anim))
    val progress by animateLottieCompositionAsState(composition)
    Column(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition,
            progress,
        )
    }





}
fun Modifier.clearFocusOnKeyboardDismiss(): Modifier = composed {
    var isFocused by remember { mutableStateOf(false) }
    var keyboardAppearedSinceLastFocused by remember { mutableStateOf(false) }
    if (isFocused) {
        val imeIsVisible = LocalWindowInsets.current.ime.isVisible
        val focusManager = LocalFocusManager.current
        LaunchedEffect(imeIsVisible) {
            if (imeIsVisible) {
                keyboardAppearedSinceLastFocused = true
            } else if (keyboardAppearedSinceLastFocused) {
                focusManager.clearFocus()
            }
        }
    }
    onFocusEvent {
        if (isFocused != it.isFocused) {
            isFocused = it.isFocused
            if (isFocused) {
                keyboardAppearedSinceLastFocused = false
            }
        }
    }
}
@Composable
fun TextField(passwordState:String, onTextChange: (String) -> Unit,value:()->Unit) {
    var isVisible by remember {
        mutableStateOf(false)
    }
    val icon = if (isVisible)
        painterResource(id = R.drawable.english)
    else
        painterResource(id = R.drawable.english)

    OutlinedTextField(
        modifier = Modifier.clearFocusOnKeyboardDismiss()
            .fillMaxWidth()
            .absolutePadding(left = 30.dp, top = 50.dp,right = 30.dp),
        value = passwordState,
        onValueChange = {
            onTextChange(it)
            value()
        },
        placeholder = {
            Text(text = "Password")
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    isVisible = !isVisible
                }) {
                Icon(painter = icon, contentDescription = "null")
            }
        },
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation =
        if (isVisible)
            VisualTransformation.None
        else
            PasswordVisualTransformation()
    )
}
@Composable
fun mirroringIcon(ltrIcon: ImageVector, rtlIcon: ImageVector): ImageVector =
    if (LocalLayoutDirection.current == LayoutDirection.Ltr) ltrIcon else rtlIcon
@Composable
fun mirroringCancelIcon() = mirroringIcon(
    ltrIcon = Icons.Default.Close, rtlIcon = Icons.Outlined.ArrowForward
)
