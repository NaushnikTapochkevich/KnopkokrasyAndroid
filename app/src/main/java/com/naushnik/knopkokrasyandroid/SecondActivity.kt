package com.naushnik.knopkokrasyandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val textView: TextView = findViewById(R.id.text_second)

        val transmitted = intent.getStringExtra(TRANSMITTED)
        textView.text = transmitted
    }
    companion object{
        const val TRANSMITTED = "transmitted"
    }
}