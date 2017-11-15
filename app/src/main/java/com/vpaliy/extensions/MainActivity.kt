package com.vpaliy.extensions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.vpaliy.kotlin_extensions.then

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    private fun requestItem(id:String?):Int{
        if(id!=null){
            return fetch(id)
        }
        throw IllegalArgumentException()
    }

    private fun fetch(id:String)=1


    fun request(id:String?)=id then(this::fetch)?:throw IllegalArgumentException()

}
