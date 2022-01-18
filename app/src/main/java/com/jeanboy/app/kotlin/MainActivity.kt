package com.jeanboy.app.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jeanboy.app.kotlin.coroutine.Test

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Test.main()
    }
}