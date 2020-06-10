package com.example.thousandaire

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_QUIT_GAME_BUTTON_CLICKED = "com.example.thousandaire.quit_game_button_clicked"

class GameOverActivity : AppCompatActivity() {

    private lateinit var gameOverTextView: TextView
    private lateinit var quitGameButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        gameOverTextView = findViewById(R.id.game_over_text_view)
        quitGameButton = findViewById(R.id.quit_game_button)

        gameOverTextView.setText(R.string.game_over_text)

        quitGameButton.setOnClickListener {
            setQuitGameButtonClicked(true)
            finish()
        }

    }

    private fun setQuitGameButtonClicked(isQuitGameButtonClicked : Boolean) {
        val data = Intent().apply {
            putExtra(EXTRA_QUIT_GAME_BUTTON_CLICKED, isQuitGameButtonClicked)
        }
        setResult(Activity.RESULT_OK, data)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val data = Intent().apply {
            putExtra(EXTRA_QUIT_GAME_BUTTON_CLICKED, false)
        }
        setResult(Activity.RESULT_CANCELED, data)
    }

    companion object {
        fun newIntent(packageContext: Context): Intent {
            return Intent(packageContext, GameOverActivity::class.java)
        }
    }
}