package com.vpaliy.android_extensions_log

import android.util.Log

fun Any.logD(message:String,tag:String=this.javaClass.name){
    Log.d(tag,message)
}

fun Any.logE(message: String, tag: String=this.javaClass.name){
    Log.e(tag,message)
}

fun Any.wtf(message:String, tag:String=this.javaClass.name){
    Log.wtf(tag,message)
}

fun Any.logW(message: String, tag: String=this.javaClass.name){
    Log.w(tag,message)
}

fun Any.logI(message: String, tag: String=this.javaClass.name){
    Log.i(tag,message)
}

fun Any.logV(message: String, tag: String=this.javaClass.name){
    Log.v(tag,message)
}

