package com.amirhusseinsoori.mvi_persian_dictinary.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.amirhusseinsoori.mvi_persian_dictinary.R
import com.amirhusseinsoori.mvi_persian_dictinary.common.utilFont


@Composable
fun AlertDialogComponent(openDialog: () -> Unit, message: String) {
    AlertDialog(
        onDismissRequest = openDialog,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                fontFamily = utilFont,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        },
        text = {
            Text(
                "modify(message)",
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                fontFamily = utilFont,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        },
        confirmButton = {
            TextButton(
                onClick = openDialog
            ) {
                Text(
                    text =
                    stringResource(R.string.cancel), color = Color.White, fontFamily = utilFont,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        },
        backgroundColor = colorResource(id = R.color.purple_700),
        contentColor = Color.White
    )
}