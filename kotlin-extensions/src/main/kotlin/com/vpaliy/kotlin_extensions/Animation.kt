package com.vpaliy.kotlin_extensions

import android.animation.ValueAnimator
import android.view.View
import android.view.ViewPropertyAnimator

fun View.getHeightAnimator(endHeight:Int, callback:((Int)->Unit)?=null):ValueAnimator{
    val heightAnimator = ValueAnimator.ofInt(height, endHeight)
    heightAnimator.addUpdateListener {
        val value = it.animatedValue as Int
        callback?.invoke(value)
        layoutParams.height =value
        requestLayout()
    }
    return heightAnimator
}

fun View.getWidthAnimator(endWidth:Int, callback:((Int)->Unit)?=null):ValueAnimator{
    val widthAnimator = ValueAnimator.ofInt(width, endWidth)
    widthAnimator.addUpdateListener {
        val value = it.animatedValue as Int
        callback?.invoke(value)
        layoutParams.width =value
        requestLayout()
    }
    return widthAnimator
}

fun ViewPropertyAnimator.scale(factor:Float)=apply {
    scaleX(factor)
    scaleY(factor)
}

fun ViewPropertyAnimator.scaleBy(factor:Float)=apply {
    scaleXBy(factor)
    scaleYBy(factor)
}

fun ViewPropertyAnimator.translation(distance:Float)=apply {
    translationY(distance)
    translationX(distance)
}

fun ViewPropertyAnimator.translationBy(distance:Float)=apply {
    translationXBy(distance)
    translationYBy(distance)
}

inline fun View.animator(build:ViewPropertyAnimator.()->Unit)
        :ViewPropertyAnimator =animate().apply(build)

inline fun ViewPropertyAnimator.scale(factor:()->Float)=scale(factor())

inline fun ViewPropertyAnimator.scaleBy(factor: () -> Float)=scaleBy(factor())

inline fun ViewPropertyAnimator.translation(factor: () -> Float)=translation(factor())

inline fun ViewPropertyAnimator.translationBy(factor: () -> Float)=translationBy(factor())


