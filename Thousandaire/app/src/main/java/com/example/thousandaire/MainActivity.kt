package com.example.thousandaire

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.example.thousandaire.models.Game
import com.example.thousandaire.models.Question

private const val TAG = "Debug"

class MainActivity : AppCompatActivity() {

    private val game: Game by lazy {
        ViewModelProviders.of(this).get(Game::class.java)
    }

    private lateinit var questionTextView: TextView
    private lateinit var answerChoiceList: List<Int>
    private lateinit var answerTopLeftButton: Button
    private lateinit var answerTopRightButton: Button
    private lateinit var answerBottomLeftButton: Button
    private lateinit var answerBottomRightButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        game.addQuestion(Question(
            R.string.question_mickey,
            R.string.answer_mickey_pluto,
            listOf<Int> (
                R.string.answer_mickey_pluto,
                R.string.answer_mickey_goofy,
                R.string.answer_mickey_minnie,
                R.string.answer_mickey_daisy
            ),
            R.string.point_mickey_amount)
        )

        game.addQuestion(Question(
            R.string.question_planet,
            R.string.answer_planet_jupiter,
            listOf<Int> (
                R.string.answer_planet_earth,
                R.string.answer_planet_mars,
                R.string.answer_planet_jupiter,
                R.string.answer_planet_venus
            ),
            R.string.point_planet_amount)
        )

        game.addQuestion(Question(
            R.string.question_gilligan,
            R.string.answer_gilligan_7,
            listOf<Int> (
                R.string.answer_gilligan_2,
                R.string.answer_gilligan_6,
                R.string.answer_gilligan_7,
                R.string.answer_gilligan_8
            ),
            R.string.point_gilligan_amount)
        )

        game.addQuestion(Question(
            R.string.question_periodic,
            R.string.answer_periodic_E,
            listOf<Int> (
                R.string.answer_periodic_Tc,
                R.string.answer_periodic_O,
                R.string.answer_periodic_Fe,
                R.string.answer_periodic_E
            ),
            R.string.point_periodic_amount)
        )

        game.addQuestion(Question(
            R.string.question_valletta,
            R.string.answer_valletta_malta,
            listOf<Int> (
                R.string.answer_valletta_croatia,
                R.string.answer_valletta_latvia,
                R.string.answer_valletta_estonia,
                R.string.answer_valletta_malta
            ),
            R.string.point_valletta_amount)
        )

        game.addQuestion(Question(
            R.string.question_miles,
            R.string.answer_miles_100,
            listOf<Int> (
                R.string.answer_miles_1,
                R.string.answer_miles_10,
                R.string.answer_miles_100,
                R.string.answer_miles_200
            ),
            R.string.point_miles_amount)
        )

        questionTextView = findViewById(R.id.question_text_view)
        answerTopLeftButton = findViewById(R.id.answer_top_left_button)
        answerTopRightButton = findViewById(R.id.answer_top_right_button)
        answerBottomLeftButton = findViewById(R.id.answer_bottom_left_button)
        answerBottomRightButton = findViewById(R.id.answer_bottom_right_button)


        answerTopLeftButton.setOnClickListener { view: View ->
            if(checkAnswer(getString(answerChoiceList[0])))
                game.proceedToNextQuestion()
            updateQuestion()
        }
        answerTopRightButton.setOnClickListener { view: View ->
            if(checkAnswer(getString(answerChoiceList[1])))
                game.proceedToNextQuestion()
            updateQuestion()
        }
        answerBottomLeftButton.setOnClickListener { view: View ->
            if(checkAnswer(getString(answerChoiceList[2])))
                game.proceedToNextQuestion()
            updateQuestion()
        }
        answerBottomRightButton.setOnClickListener { view: View ->
            if(checkAnswer(getString(answerChoiceList[3])))
                game.proceedToNextQuestion()
            updateQuestion()
        }

        updateQuestion()
    }

    private fun updateQuestion() {
        val questionTextResId = game.currentQuestionText
        questionTextView.setText(questionTextResId)

        answerChoiceList = game.currentQuestionChoices
        answerTopLeftButton.setText(answerChoiceList[0])
        answerTopRightButton.setText(answerChoiceList[1])
        answerBottomLeftButton.setText(answerChoiceList[2])
        answerBottomRightButton.setText(answerChoiceList[3])
    }

    private fun checkAnswer(userAnswer: String) : Boolean {
        val currentQuestionAnswer = getString(game.currentQuestionAnswer)
        return when {
            userAnswer == currentQuestionAnswer -> true
            else -> false
        }
    }

}
