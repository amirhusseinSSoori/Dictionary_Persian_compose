package com.amirhusseinsoori.mvi_persian_dictinary.common.neumorphic.shapes


import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import com.amirhusseinsoori.mvi_persian_dictinary.common.neumorphic.internal.BlurMaker
import com.amirhusseinsoori.mvi_persian_dictinary.common.neumorphic.shapes.ShapeConfig


/**
 * Represents neumorphic shape
 */
interface NeuShape {

    fun drawShadows(drawScope: ContentDrawScope, blurMaker: BlurMaker, shapeConfig: ShapeConfig)
}