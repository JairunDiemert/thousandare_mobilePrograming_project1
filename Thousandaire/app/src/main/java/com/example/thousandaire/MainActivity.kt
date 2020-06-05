package com.example.thousandaire

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.example.thousandaire.models.Game

class MainActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView

    private val game: Game by lazy {
        ViewModelProviders.of(this).get(Game::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.question_text_view)

        updateQuestion()
    }

    private fun updateQuestion() {
        val questionTextResId = game.currentQuestionText
        questionTextView.setText(questionTextResId)
    }

}
