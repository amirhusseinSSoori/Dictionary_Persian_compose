package com.amirhusseinsoori.mvi_persian_dictinary.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import com.amirhusseinsoori.mvi_persian_dictinary.R

val utilFont = FontFamily(
    Font(R.font.domine_bold, FontWeight.Light),
    Font(R.font.domine_regular, FontWeight.Normal),
    Font(R.font.montserrat_medium, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.iransanse_medium, FontWeight.Medium),
    Font(R.font.montserrat_semibold, FontWeight.Bold)
)

/**
 * Returns the correct icon based on the current layout direction.
 */
@Composable
fun mirroringIcon(ltrIcon: ImageVector, rtlIcon: ImageVector): ImageVector =
    if (LocalLayoutDirection.current == LayoutDirection.Ltr) ltrIcon else rtlIcon

/**
 * Returns the correct back navigation icon based on the current layout direction.
 */
@Composable
fun mirroringBackIcon() = mirroringIcon(
    ltrIcon = Icons.Outlined.ArrowBack, rtlIcon = Icons.Outlined.ArrowForward
)
