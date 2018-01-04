package com.vpaliy.kotlin_extensions

import android.content.res.Configuration
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.IntRange
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat

fun Fragment.getDimension(@DimenRes id: Int)
    = resources.getDimension(id)

fun Fragment.getDimensionPixelOffset(@DimenRes id: Int)
    = resources.getDimensionPixelOffset(id)

fun Fragment.getDimensionPixelSize(@DimenRes id: Int)
    = resources.getDimensionPixelSize(id)

fun Fragment.getColor(@ColorRes id: Int) = ContextCompat.getColor(context, id)

fun Fragment.isLandscape() = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

fun Fragment.isPortrait() = resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

fun Fragment.showMessage(@StringRes resource: Int, @IntRange(from = -2, to = 0) duration: Int = Snackbar.LENGTH_LONG) {
  view.showMessage(resource, duration)
}

fun Fragment.getSnackbar(@StringRes resource: Int, @IntRange(from = -2, to = 0) duration: Int = Snackbar.LENGTH_LONG)
    = view.getSnackbar(resource, duration)
