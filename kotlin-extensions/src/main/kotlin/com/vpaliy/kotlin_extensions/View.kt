package com.vpaliy.kotlin_extensions

import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun View.scale(factor:Float)=apply {
    scaleY=factor
    scaleX=factor
}

fun View.getDimension(@DimenRes id:Int)=resources.getDimension(id)

fun View.getDimensionPixelOffset(@DimenRes id:Int)=resources.getDimensionPixelOffset(id)

fun View.getDimensionPixelSize(@DimenRes id:Int)=resources.getDimensionPixelSize(id)

fun View.getColor(@ColorRes id:Int)=ContextCompat.getColor(context,id)

fun View.getDrawable(@DrawableRes id:Int)=ContextCompat.getDrawable(context,id)

fun ViewGroup.inflate(@LayoutRes id:Int)
        :View=LayoutInflater.from(context).inflate(id,this,false)

inline fun View.click(crossinline callback:(View)->Unit)
        =setOnClickListener{ callback(it) }

inline fun View.longClick(crossinline callback: (View) -> Boolean)
        =setOnLongClickListener{ callback(it) }

