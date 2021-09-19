package com.amirhusseinsoori.mvi_persian_dictinary.common.neumorphic.shapes

import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.amirhusseinsoori.mvi_persian_dictinary.common.neumorphic.internal.BlurMaker
import me.nikhilchaudhari.library.shapes.*
import me.nikhilchaudhari.library.shapes.drawOnBackground



open class Pot(private val cornerType: CornerType = CornerType.Rounded()) : NeuShape {

    override fun drawShadows(
        drawScope: ContentDrawScope,
        blurMaker: BlurMaker,
        shapeConfig: ShapeConfig
    ) {
        shapeConfig.cornerType = cornerType
        drawScope.drawOnBackground(shapeConfig, blurMaker)
        drawScope.drawContent()
        drawScope.drawOnForeground(shapeConfig, blurMaker)
    }

    class Oval(): Pot(CornerType.Oval)

    class Rounded(radius: Dp = 12.dp): Pot(CornerType.Rounded(radius))
}