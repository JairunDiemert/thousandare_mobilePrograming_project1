package com.example.thousandaire.models

import androidx.lifecycle.ViewModel
import com.example.thousandaire.R

class Game : ViewModel() {

    private val mickeyChoices = listOf<Int> (
        R.string.answer_mickey_pluto,
        R.string.answer_mickey_goofy,
        R.string.answer_mickey_minnie,
        R.string.answer_mickey_daisy
    )

    private val planetChoices = listOf<Int> (
        R.string.answer_planet_earth,
        R.string.answer_planet_mars,
        R.string.answer_planet_jupiter,
        R.string.answer_planet_venus
    )

    private val gilliganChoices = listOf<Int> (
        R.string.answer_gilligan_2,
        R.string.answer_gilligan_6,
        R.string.answer_gilligan_7,
        R.string.answer_gilligan_8
    )

    private val periodicChoices = listOf<Int> (
        R.string.answer_periodic_Tc,
        R.string.answer_periodic_O,
        R.string.answer_periodic_Fe,
        R.string.answer_periodic_E
    )

    private val vallettaChoices = listOf<Int> (
        R.string.answer_valletta_croatia,
        R.string.answer_valletta_latvia,
        R.string.answer_valletta_estonia,
        R.string.answer_valletta_malta
    )

    private val milesChoices = listOf<Int> (
        R.string.answer_miles_1,
        R.string.answer_miles_10,
        R.string.answer_miles_100,
        R.string.answer_miles_200
    )

    private val questionBank = listOf(
        Question(R.string.question_mickey, R.string.answer_mickey_pluto, mickeyChoices, R.string.point_mickey_amount),
        Question(R.string.question_planet, R.string.answer_planet_jupiter, planetChoices, R.string.point_planet_amount),
        Question(R.string.question_gilligan, R.string.answer_gilligan_7, gilliganChoices, R.string.point_gilligan_amount),
        Question(R.string.question_periodic, R.string.answer_periodic_E, periodicChoices, R.string.point_periodic_amount),
        Question(R.string.question_valletta, R.string.answer_valletta_malta, vallettaChoices, R.string.point_valletta_amount),
        Question(R.string.question_miles, R.string.answer_miles_100, milesChoices, R.string.point_miles_amount)
    )

    var currentIndex = 0

    val currentQuestionText: Int
        get() = questionBank[currentIndex].questionTextId

}