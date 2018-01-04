package com.vpaliy.kotlin_extensions

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment

fun Intent.start(context: Context, bundle: Bundle? = null)
    = context.startActivity(this, bundle)

fun Intent.startForResult(activity: Activity, code: Int, options: Bundle? = null)
    = activity.startActivityForResult(this, code, options)

fun Intent.startForResult(fragment: Fragment, code: Int, options: Bundle? = null)
    = fragment.startActivityForResult(this, code, options)

fun Intent.clearTask() = apply {
  addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
}

fun Intent.clearTop() = apply {
  addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
}

fun Intent.clearWhenTaskReset() = apply {
  addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
}

fun Intent.excludeFromRecents() = apply {
  addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
}

fun Intent.multipleTask() = apply {
  addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
}

fun Intent.newTask() = apply {
  addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
}

fun Intent.noAnimation() = apply {
  addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
}

fun Intent.noHistory() = apply {
  addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
}

fun Intent.singleTop() = apply {
  addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
}

inline fun <reified T : Activity> Context.startActivity(bundle: Bundle? = null) {
  startActivity(Intent(this, T::class.java).putExtras(bundle))
}

inline fun <reified T : Service> Context.startService(bundle: Bundle? = null) {
  startService(Intent(this, T::class.java).putExtras(bundle))
}

inline fun <reified T : Activity> Fragment.startActivity(bundle: Bundle? = null) {
  startActivity(Intent(context, T::class.java).putExtras(bundle))
}

inline fun <reified T : Service> Fragment.startService(bundle: Bundle? = null) {
  context.startService<T>(bundle)
}

