package com.amirhusseinsoori.mvi_persian_dictinary.common.neumorphic.shapes

import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.amirhusseinsoori.mvi_persian_dictinary.common.neumorphic.internal.BlurMaker
import me.nikhilchaudhari.library.shapes.drawOnForeground


/**
 * Pressed or Puddle shape
 * ___              ___
 *    \____________/
 *
 */
open class Pressed(private val cornerType: CornerType = CornerType.Rounded()) : NeuShape {

    override fun drawShadows(
        drawScope: ContentDrawScope,
        blurMaker: BlurMaker,
        shapeConfig: ShapeConfig
    ) {
        shapeConfig.cornerType = cornerType
        drawScope.drawContent()
        drawScope.drawOnForeground(shapeConfig, blurMaker)
    }

    class Oval(): Pressed(CornerType.Oval)

    class Rounded(radius: Dp = 12.dp): Pressed(CornerType.Rounded(radius))
}