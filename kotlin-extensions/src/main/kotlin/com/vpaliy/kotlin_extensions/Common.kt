package com.vpaliy.kotlin_extensions

import kotlin.reflect.KClass

internal fun <T : Any> KClass<T>.createInstance(): T {
    val noArgConstructor = constructors.find {
        it.parameters.isEmpty()
    }
    noArgConstructor ?: throw IllegalArgumentException(
            "Class must have a no-argument constructor")

    return noArgConstructor.call()
}

infix fun<T> Boolean.then(value:T?)
        =if(this) value else null

inline fun <T> Boolean.then(function: () -> T, default:()->T)
        =if(this) function() else default()

infix inline fun <reified T> Boolean.then(function:()->T)
        =if(this) function() else null

infix inline fun <reified T,reified Type> Type?.then(callback:(Type)->T)
        =if(this!=null) callback(this) else null