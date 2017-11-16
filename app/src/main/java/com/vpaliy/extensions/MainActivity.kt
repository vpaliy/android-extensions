package com.vpaliy.extensions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.vpaliy.kotlin_extensions.info
import com.vpaliy.kotlin_extensions.warning

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        warning("Hello").info("Second")
    }
}
