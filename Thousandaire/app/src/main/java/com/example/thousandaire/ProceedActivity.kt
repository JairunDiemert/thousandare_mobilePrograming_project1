package com.example.thousandaire

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ProceedActivity : AppCompatActivity() {

    private lateinit var proceedTextView: TextView
    private lateinit var goOnButton: Button
    private lateinit var quitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proceed)

        proceedTextView = findViewById(R.id.proceed_text_view)
        goOnButton = findViewById(R.id.go_on_button)
        quitButton = findViewById(R.id.quit_button)

    }
}