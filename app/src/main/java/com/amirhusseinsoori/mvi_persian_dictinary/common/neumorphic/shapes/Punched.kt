package com.amirhusseinsoori.mvi_persian_dictinary.common.neumorphic.shapes

import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.amirhusseinsoori.mvi_persian_dictinary.common.neumorphic.internal.BlurMaker
import me.nikhilchaudhari.library.shapes.drawOnBackground


/**
 * Punched or Bumped shape
 *    _________
 * __/         \__
 */
open class Punched(private val cornerType: CornerType = CornerType.Rounded()) : NeuShape {

    override fun drawShadows(
        drawScope: ContentDrawScope,
        blurMaker: BlurMaker,
        shapeConfig: ShapeConfig
    ) {
        shapeConfig.cornerType = cornerType
        drawScope.drawOnBackground(shapeConfig, blurMaker)
        drawScope.drawContent()
    }

    class Oval() : Punched(CornerType.Oval)

    class Rounded(radius: Dp = 12.dp) : Punched(CornerType.Rounded(radius))
}