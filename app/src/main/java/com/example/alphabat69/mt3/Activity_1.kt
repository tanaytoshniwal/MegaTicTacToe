package com.example.alphabat69.mt3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

class Activity_1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)
    }
}
