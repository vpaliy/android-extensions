package com.vpaliy.kotlin_extensions

import android.util.Log


fun Any.debug(message:Any?, tag:String=this.javaClass.name){
    Log.d(tag,message.toString())
}

fun Any.error(message: Any?, tag: String=this.javaClass.name){
    Log.e(tag,message.toString())
}

fun Any.wtf(message:Any?, tag:String=this.javaClass.name){
    Log.wtf(tag,message.toString())
}

fun Any.warning(message: Any?, tag: String=this.javaClass.name){
    Log.w(tag,message.toString())
}

fun Any.info(message: Any?, tag: String=this.javaClass.name){
    Log.i(tag,message.toString())
}

fun Any.verbose(message: Any?, tag: String=this.javaClass.name){
    Log.v(tag,message.toString())
}

inline fun Any.debug(message:()->Any?, tag:String=this.javaClass.name){
    Log.d(tag,message().toString())
}

inline fun Any.error(message:()-> Any?, tag: String=this.javaClass.name){
    Log.e(tag,message().toString())
}

inline fun Any.wtf(message:()->Any?, tag:String=this.javaClass.name){
    Log.wtf(tag,message().toString())
}

inline fun Any.warning(message:()->Any?, tag: String=this.javaClass.name){
    Log.w(tag,message().toString())
}

inline fun Any.info(message:()-> Any?, tag: String=this.javaClass.name){
    Log.i(tag,message().toString())
}

inline fun Any.verbose(message:()->Any?, tag: String=this.javaClass.name){
    Log.v(tag,message().toString())
}





