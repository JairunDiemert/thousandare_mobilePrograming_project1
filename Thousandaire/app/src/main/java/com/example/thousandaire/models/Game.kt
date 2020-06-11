package com.example.thousandaire.models

import androidx.lifecycle.ViewModel
import com.example.thousandaire.R

class Game : ViewModel() {

    private var questions = ArrayList<Question>()

    private var currentQuestionIndex = 0

    val currentQuestionAnswer: Int
        get(): Int {
            if (questions.isEmpty())
                return R.string.default_text
            return questions[currentQuestionIndex].answerId
        }

    val currentQuestionText: Int
        get(): Int {
            if (questions.isEmpty())
                return R.string.default_text
            return questions[currentQuestionIndex].questionTextId
        }

    val nextQuestionAmount: Int
        get(): Int {
            if (isFinalQuestion())
                return questions[currentQuestionIndex].amount
            return questions[currentQuestionIndex + 1].amount
        }

    val currentQuestionChoices: List<Int>
        get(): List<Int> {
            if (questions.isEmpty())
                return listOf(
                    R.string.default_text,
                    R.string.default_text,
                    R.string.default_text,
                    R.string.default_text
                )
            return questions[currentQuestionIndex].choiceIds
        }

    fun addQuestion(question: Question) {
        questions.add(question)
    }

    fun isFinalQuestion(): Boolean {
        if (currentQuestionIndex >= questions.size - 1)
            return true
        return false
    }

    fun proceedToNextQuestion() {
        currentQuestionIndex = (currentQuestionIndex + 1) % questions.size
    }

}