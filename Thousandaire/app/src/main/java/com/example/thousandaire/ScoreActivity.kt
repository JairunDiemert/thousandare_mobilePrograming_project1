package com.example.thousandaire

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private const val EXTRA_CURRENT_AMOUNT_EARNED = "com.example.thousandaire.current_amount_earned"
const val EXTRA_PLAY_OVER_CLICKED = "com.example.thousandaire.play_over_clicked"

class ScoreActivity : AppCompatActivity() {

    private var currentAmountEarned = R.string.default_text

    private lateinit var scoreTextView: TextView
    private lateinit var playOverButton: Button
    private lateinit var quitGameButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        currentAmountEarned = intent.getIntExtra(EXTRA_CURRENT_AMOUNT_EARNED, R.string.default_text)

        scoreTextView = findViewById(R.id.score_text_view)
        playOverButton = findViewById(R.id.play_over_button)
        quitGameButton = findViewById(R.id.quit_game_button)

        setTextView(currentAmountEarned)

        quitGameButton.setOnClickListener {
            finishAffinity()
        }

        playOverButton.setOnClickListener{
            setPlayOverClicked(true)
            finish()
        }
    }

    private fun setPlayOverClicked(isPlayOverButtonClicked : Boolean) {
        val data = Intent().apply {
            putExtra(EXTRA_PLAY_OVER_CLICKED, isPlayOverButtonClicked)
        }
        setResult(Activity.RESULT_OK, data)
    }

    private fun setTextView(currentAmountEarned: Int) {
        val currentAmount : String = when {
            currentAmountEarned == R.string.point_planet_amount -> getString(R.string.point_mickey_amount)
            currentAmountEarned == R.string.point_gilligan_amount -> getString(R.string.point_planet_amount)
            currentAmountEarned == R.string.point_periodic_amount -> getString(R.string.point_gilligan_amount)
            currentAmountEarned == R.string.point_valletta_amount -> getString(R.string.point_periodic_amount)
            currentAmountEarned == R.string.point_miles_amount -> getString(R.string.point_valletta_amount)
            currentAmountEarned == R.string.you_won_score -> getString(R.string.point_miles_amount)
            else -> getString(R.string.default_text)
        }
        val text : String = "Congratulations!\nYou earned \$$currentAmount."
        scoreTextView.setText(text)
    }

    companion object {
        fun newIntent(packageContext: Context, currentAmountEarned : Int): Intent {
            return Intent(packageContext, ScoreActivity::class.java).apply {
                putExtra(EXTRA_CURRENT_AMOUNT_EARNED, currentAmountEarned)
            }
        }
    }
}