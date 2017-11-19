package com.vpaliy.kotlin_extensions

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.view.View
import android.view.ViewPropertyAnimator

fun View.getHeightAnimator(endHeight:Int, callback:((Int)->Unit)?=null):ValueAnimator{
    val heightAnimator = ValueAnimator.ofInt(height, endHeight)
    heightAnimator.addUpdateListener {
        val value = it.animatedValue as Int
        callback?.invoke(value)
        layoutParams.height =value
        requestLayout()
    }
    return heightAnimator
}

fun View.getWidthAnimator(endWidth:Int, callback:((Int)->Unit)?=null):ValueAnimator{
    val widthAnimator = ValueAnimator.ofInt(width, endWidth)
    widthAnimator.addUpdateListener {
        val value = it.animatedValue as Int
        callback?.invoke(value)
        layoutParams.width =value
        requestLayout()
    }
    return widthAnimator
}

fun ViewPropertyAnimator.scale(factor:Float)=apply {
    scaleX(factor)
    scaleY(factor)
}

fun ViewPropertyAnimator.scaleBy(factor:Float)=apply {
    scaleXBy(factor)
    scaleYBy(factor)
}

fun ViewPropertyAnimator.translation(distance:Float)=apply {
    translationY(distance)
    translationX(distance)
}

fun ViewPropertyAnimator.translationBy(distance:Float)=apply {
    translationXBy(distance)
    translationYBy(distance)
}

fun AnimatorSet.playWith(vararg items:Animator)=apply {
    playTogether(items.toMutableList())
}

fun Animator.playWith(animator: Animator): Animator {
    if(animator is AnimatorSet)
        return animator.playWith(this)
    else if(this is AnimatorSet)
        return this.playWith(animator)
    return AnimatorSet().playWith(this,animator)
}


inline fun View.animator(build:ViewPropertyAnimator.()->Unit)
        :ViewPropertyAnimator =animate().apply(build)

inline fun ViewPropertyAnimator.scale(factor:()->Float)=scale(factor())

inline fun ViewPropertyAnimator.scaleBy(factor: () -> Float)=scaleBy(factor())

inline fun ViewPropertyAnimator.translation(factor: () -> Float)=translation(factor())

inline fun ViewPropertyAnimator.translationBy(factor: () -> Float)=translationBy(factor())

fun Animator.onEnd(callback:(Animator?)->Unit)=keeper().onEnd(callback)

fun Animator.onStart(callback:(Animator?)->Unit)=keeper().onStart(callback)

fun Animator.onCancel(callback:(Animator?)->Unit)=keeper().onCancel(callback)

fun Animator.onRepeat(callback:(Animator?)->Unit)=keeper().onRepeat(callback)

fun Animator.onUpdate(callback: (ValueAnimator?) -> Unit)=keeper().onUpdate(callback)

fun ViewPropertyAnimator.onEnd(callback: (Animator?) -> Unit)=keeper().onEnd(callback)

fun ViewPropertyAnimator.onStart(callback: (Animator?) -> Unit)=keeper().onStart(callback)

fun ViewPropertyAnimator.onRepeat(callback: (Animator?) -> Unit)=keeper().onRepeat(callback)

fun ViewPropertyAnimator.onCancel(callback: (Animator?) -> Unit)=keeper().onCancel(callback)

fun ViewPropertyAnimator.onUpdate(callback: (ValueAnimator?) -> Unit)=keeper().onUpdate(callback)

abstract class AbstractKeeper<T>(protected val target:T){
    private val executor=ListenerExecutor()

    init {
        @Suppress("LeakingThis")
        hookUp(listener = executor)
    }

    fun onEnd(callback:(Animator?) -> Unit)=apply {
        executor.end=callback
    }

    fun onStart(callback: (Animator?) -> Unit)=apply {
        executor.start=callback
    }

    fun onCancel(callback: (Animator?) -> Unit)=apply {
        executor.cancel=callback
    }

    fun onRepeat(callback: (Animator?) -> Unit)=apply {
        executor.repeat=callback
    }

    fun onUpdate(callback: (ValueAnimator?) -> Unit)=apply {
        executor.update=callback
    }

    fun animator()=target

    internal abstract fun hookUp(listener:Animator.AnimatorListener)
}

private fun ViewPropertyAnimator.keeper():AbstractKeeper<ViewPropertyAnimator>
        =PropertyKeeper(this)

private fun Animator.keeper():AbstractKeeper<Animator>
        =AnimatorKeeper(this)

private class PropertyKeeper(target:ViewPropertyAnimator)
    :AbstractKeeper<ViewPropertyAnimator>(target){
    override fun hookUp(listener: Animator.AnimatorListener) {
        target.setListener(listener)
    }
}

private class AnimatorKeeper(target:Animator)
    :AbstractKeeper<Animator>(target){
    override fun hookUp(listener: Animator.AnimatorListener) {
        target.addListener(listener)
    }
}

private class ListenerExecutor:Animator.AnimatorListener,
        ValueAnimator.AnimatorUpdateListener {
    var end:((Animator?) -> Unit)? = null
    var start: ((Animator?) ->Unit)? = null
    var cancel:((Animator?)->Unit)?=null
    var repeat:((Animator?)->Unit)?=null
    var update:((ValueAnimator?)->Unit)?=null

    override fun onAnimationCancel(animation: Animator?) {
        cancel?.invoke(animation)
    }

    override fun onAnimationEnd(animation: Animator?) {
        end?.invoke(animation)
    }

    override fun onAnimationRepeat(animation: Animator?) {
        repeat?.invoke(animation)
    }

    override fun onAnimationStart(animation: Animator?) {
        start?.invoke(animation)
    }

    override fun onAnimationUpdate(animator: ValueAnimator?) {
        update?.invoke(animator)
    }
}