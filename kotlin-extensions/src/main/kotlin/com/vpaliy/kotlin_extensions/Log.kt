package com.vpaliy.kotlin_extensions

import android.util.Log

fun Any.debug(message:Any?)=apply {
    Log.d(tag,message.toString())
}

fun Any.error(message: Any?)=apply {
    Log.e(tag,message.toString())
}

fun Any.wtf(message:Any?)=apply{
    Log.wtf(tag,message.toString())
}

fun Any.warning(message: Any?)=apply{
    Log.w(tag,message.toString())
}

fun Any.info(message: Any?)=apply{
    Log.i(tag,message.toString())
}

fun Any.verbose(message: Any?)=apply{
    Log.v(tag,message.toString())
}

fun Any.debug(tag:String, message:Any?)=apply {
    Log.d(tag,message.toString())
}

fun Any.error(tag:String, message: Any?)=apply {
    Log.e(tag,message.toString())
}

fun Any.wtf(tag:String, message:Any?)=apply{
    Log.wtf(tag,message.toString())
}

fun Any.warning(tag:String, message: Any?)=apply{
    Log.w(tag,message.toString())
}

fun Any.info(tag:String, message: Any?)=apply{
    Log.i(tag,message.toString())
}

fun Any.verbose(tag:String, message: Any?)=apply{
    Log.v(tag,message.toString())
}

inline fun Any.debug(message:()->Any?)=debug(message())

inline fun Any.error(message:()-> Any?)=error(message())

inline fun Any.wtf(message:()->Any?)=wtf(message())

inline fun Any.warning(message:()->Any?)=warning(message())

inline fun Any.info(message:()-> Any?)=info(message())

inline fun Any.verbose(message:()->Any?)=verbose(message())

inline fun Any.debug(tag:String, message:()->Any?)=debug(tag,message())

inline fun Any.error(tag:String, message:()-> Any?)=error(tag,message())

inline fun Any.wtf(tag:String, message:()->Any?)=wtf(tag,message())

inline fun Any.warning(tag:String, message:()->Any?)=warning(tag,message())

inline fun Any.info(tag:String, message:()-> Any?)=info(tag,message())

inline fun Any.verbose(tag:String, message:()->Any?)=verbose(tag,message())

private val Any.tag
    get() = javaClass.simpleName
