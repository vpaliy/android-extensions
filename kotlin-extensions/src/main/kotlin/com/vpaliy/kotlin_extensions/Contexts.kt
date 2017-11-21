package com.vpaliy.kotlin_extensions

import android.content.Context
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater

fun Context.inflater()=LayoutInflater.from(this)

fun Context.getCompatDrawable(@DrawableRes id:Int)
        =ContextCompat.getDrawable(this,id)

fun Context.getCompatColor(@ColorRes id:Int)
        =ContextCompat.getColor(this,id)

fun Context.getDimension(@DimenRes id:Int)
        =resources.getDimension(id)

fun Context.getDimensionPixelOffset(@DimenRes id:Int)
        =resources.getDimensionPixelOffset(id)

fun Context.getDimensionPixelSize(@DimenRes id:Int)
        =resources.getDimensionPixelSize(id)
