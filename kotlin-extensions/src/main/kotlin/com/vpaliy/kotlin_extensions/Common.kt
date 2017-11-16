package com.vpaliy.kotlin_extensions

infix fun<T> Boolean.then(value:T?)
        =if(this) value else null

inline fun <T> Boolean.then(function: () -> T, default:()->T)
        =if(this) function() else default()

infix inline fun <reified T> Boolean.then(function:()->T)
        =if(this) function() else null

infix inline fun <reified T,reified Type> Type?.then(callback:(Type)->T)
        =if(this!=null) callback(this) else null