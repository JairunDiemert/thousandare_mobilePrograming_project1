package com.example.thousandaire

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.thousandaire.models.Game

private const val EXTRA_CURRENT_QUESTION_AMOUNT = "com.example.thousandaire.current_question_amount"
private const val EXTRA_NEXT_QUESTION_AMOUNT = "com.example.thousandaire.next_question_amount"

class ProceedActivity : AppCompatActivity() {

    private var currentQuestionAmount = R.string.default_text
    private var nextQuestionAmount = R.string.default_text

    companion object {
        fun newIntent(packageContext: Context, currentQuestionAmount : Int, nextQuestionAmount : String): Intent {
            return Intent(packageContext, ProceedActivity::class.java).apply {
                putExtra(EXTRA_CURRENT_QUESTION_AMOUNT, currentQuestionAmount)
                putExtra(EXTRA_NEXT_QUESTION_AMOUNT, nextQuestionAmount)
            }
        }
    }
}