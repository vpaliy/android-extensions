package com.vpaliy.kotlin_extensions

import android.support.annotation.DimenRes
import android.support.v4.app.Fragment

fun Fragment.getDimension(@DimenRes id:Int)
        =resources.getDimension(id)

fun Fragment.getDimensionPixelOffset(@DimenRes id:Int)
        =resources.getDimensionPixelOffset(id)

fun Fragment.getDimensionPixelSize(@DimenRes id:Int)
        =resources.getDimensionPixelSize(id)


