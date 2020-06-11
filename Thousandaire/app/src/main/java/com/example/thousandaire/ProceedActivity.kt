package com.example.thousandaire

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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
            finish()
        }
        quitButton.setOnClickListener {
            setProceedButtonClicked(false)
            finish()
        }
    }

    private fun setTextView(nextQuestionAmount: Int) {
        val currentAmount: String = when (nextQuestionAmount) {
            R.string.point_planet_amount -> getString(R.string.point_mickey_amount)
            R.string.point_gilligan_amount -> getString(R.string.point_planet_amount)
            R.string.point_periodic_amount -> getString(R.string.point_gilligan_amount)
            R.string.point_valletta_amount -> getString(R.string.point_periodic_amount)
            R.string.point_miles_amount -> getString(R.string.point_valletta_amount)
            else -> getString(R.string.default_text)
        }
        val text: String = "Correct! You have earned \$$currentAmount. " +
                "Would you care to try for \$${getString(nextQuestionAmount)}?"
        proceedTextView.text = text
    }

    private fun setProceedButtonClicked(isProceedButtonClicked: Boolean) {
        val data = Intent().apply {
            putExtra(EXTRA_PROCEED_BUTTON_CLICKED, isProceedButtonClicked)
        }
        setResult(Activity.RESULT_OK, data)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setResult(Activity.RESULT_CANCELED)
    }

    companion object {
        fun newIntent(packageContext: Context, nextQuestionAmount: Int): Intent {
            return Intent(packageContext, ProceedActivity::class.java).apply {
                putExtra(EXTRA_NEXT_QUESTION_AMOUNT, nextQuestionAmount)
            }
        }
    }

}