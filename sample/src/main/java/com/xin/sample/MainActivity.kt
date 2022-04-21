package com.xin.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xin.box.lazy.LazyInitializer

class MainActivity : AppCompatActivity() {

    private val lazyString: LazyInitializer<String> = LazyInitializer {
        "1111"
    }

    private val lazyStringKt by lazy { "" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lazyString.get().length
        lazyStringKt.length
    }

}