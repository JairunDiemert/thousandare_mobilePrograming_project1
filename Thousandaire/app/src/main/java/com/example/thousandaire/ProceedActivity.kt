package com.example.thousandaire

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private const val EXTRA_NEXT_QUESTION_AMOUNT = "com.example.thousandaire.next_question_amount"
const val EXTRA_PROCEED_BUTTON_CLICKED = "com.example.thousandaire.proceed_button_clicked"

class ProceedActivity : AppCompatActivity() {

    private var nextQuestionAmount = R.string.default_text

    private lateinit var proceedTextView: TextView
    private lateinit var goOnButton: Button
    private lateinit var quitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proceed)

        nextQuestionAmount = intent.getIntExtra(EXTRA_NEXT_QUESTION_AMOUNT, R.string.default_text)

        proceedTextView = findViewById(R.id.proceed_text_view)
        goOnButton = findViewById(R.id.go_on_button)
        quitButton = findViewById(R.id.quit_button)

        setTextView(nextQuestionAmount)

        goOnButton.setOnClickListener {
            setProceedButtonClicked(true)
        }
    }

    private fun setTextView(nextQuestionAmount : Int) {
        val currentAmount : String = when {
            nextQuestionAmount == R.string.point_planet_amount -> getString(R.string.point_mickey_amount)
            nextQuestionAmount == R.string.point_gilligan_amount -> getString(R.string.point_planet_amount)
            nextQuestionAmount == R.string.point_periodic_amount -> getString(R.string.point_gilligan_amount)
            nextQuestionAmount == R.string.point_valletta_amount -> getString(R.string.point_periodic_amount)
            nextQuestionAmount == R.string.point_miles_amount -> getString(R.string.point_valletta_amount)
            else -> getString(R.string.default_text)
        }
        val text : String = "Correct! You have earned \$$currentAmount. " +
                "Would you care to try for \$${getString(nextQuestionAmount)}?"
        proceedTextView.setText(text)
    }

    private fun setProceedButtonClicked(isProceedButtonClicked : Boolean) {
        val data = Intent().apply {
            putExtra(EXTRA_PROCEED_BUTTON_CLICKED, isProceedButtonClicked)
        }
        setResult(Activity.RESULT_OK, data)
    }

    companion object {
        fun newIntent(packageContext: Context, nextQuestionAmount : Int): Intent {
            return Intent(packageContext, ProceedActivity::class.java).apply {
                putExtra(EXTRA_NEXT_QUESTION_AMOUNT, nextQuestionAmount)
            }
        }
    }

}