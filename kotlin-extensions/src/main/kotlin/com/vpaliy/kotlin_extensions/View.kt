package com.vpaliy.kotlin_extensions

import android.support.annotation.*
import android.support.annotation.IntRange
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver

fun View.scale(factor: Float) = apply {
  scaleY = factor
  scaleX = factor
}

fun View.hide(isGone: Boolean = false) {
  visibility = isGone then View.GONE ?: View.INVISIBLE
}

fun View.show() {
  visibility = View.VISIBLE
}

fun View.setHeight(height: Int) {
  layoutParams.height = height
  requestLayout()
}

fun View.setWidth(width: Int) {
  layoutParams.width = width
  requestLayout()
}

fun View.setSize(height: Int, width: Int) {
  layoutParams.width = width
  layoutParams.height = height
  requestLayout()
}

fun View.endX() = width + x

fun View.endY() = height + y

fun View.halfWidth() = width / 2

fun View.halfHeight() = height / 2

fun View.getMinHeight() = ViewCompat.getMinimumHeight(this)

fun View.getDimension(@DimenRes id: Int) = resources.getDimension(id)

fun View.getDimensionPixelOffset(@DimenRes id: Int) = resources.getDimensionPixelOffset(id)

fun View.getDimensionPixelSize(@DimenRes id: Int) = resources.getDimensionPixelSize(id)

fun View.getColor(@ColorRes id: Int) = ContextCompat.getColor(context, id)

fun View.getDrawable(@DrawableRes id: Int) = ContextCompat.getDrawable(context, id)

fun ViewGroup.inflate(@LayoutRes id: Int)
    : View = LayoutInflater.from(context).inflate(id, this, false)

inline fun View.click(crossinline callback: (View) -> Unit)
    = setOnClickListener { callback(it) }

inline fun View.longClick(crossinline callback: (View) -> Boolean)
    = setOnLongClickListener { callback(it) }

fun SwipeRefreshLayout.turnOff() = setOnRefreshListener { isRefreshing = false }

inline fun View.addTemporaryOnPreDraw(crossinline callback: () -> Unit) {
  viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
    override fun onPreDraw(): Boolean {
      viewTreeObserver.removeOnPreDrawListener(this)
      callback()
      return true
    }
  })
}

fun View?.showMessage(@StringRes resource: Int, @IntRange(from = -2, to = 0) duration: Int = Snackbar.LENGTH_LONG) {
  this?.let { Snackbar.make(it, resource, duration).show() }
}

fun View?.getSnackbar(@StringRes resource: Int, @IntRange(from = -2, to = 0) duration: Int = Snackbar.LENGTH_LONG)
    = (this != null) then Snackbar.make(this!!, resource, duration)
