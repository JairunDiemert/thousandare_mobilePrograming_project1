package com.example.thousandaire.models

data class Question(
    val questionTextId: Int,
    val answerId: Int,
    val choiceIds: List<Int>,
    val amount: Int
)