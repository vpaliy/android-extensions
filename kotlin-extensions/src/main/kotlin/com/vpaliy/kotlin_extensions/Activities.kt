package com.vpaliy.kotlin_extensions

import android.app.Activity
import android.support.annotation.DimenRes

fun Activity.getDimension(@DimenRes id:Int)
        =resources.getDimension(id)

fun Activity.getDimensionPixelOffset(@DimenRes id:Int)
        =resources.getDimensionPixelOffset(id)

fun Activity.getDimensionPixelSize(@DimenRes id:Int)
        =resources.getDimensionPixelSize(id)