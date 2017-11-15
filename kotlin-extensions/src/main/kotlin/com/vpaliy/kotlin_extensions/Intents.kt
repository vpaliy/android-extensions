package com.vpaliy.kotlin_extensions

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.Bundle

fun Intent.start(context: Context,bundle: Bundle?=null)
        =context.startActivity(this,bundle)

fun Intent.startForResult(activity: Activity, code:Int, options:Bundle?=null)
        =activity.startActivityForResult(this,code,options)

fun Intent.startForResult(fragment:Fragment, code:Int, options:Bundle?=null)
        =fragment.startActivityForResult(this,code,options)