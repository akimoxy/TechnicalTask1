package com.example.technicaltask1.login.secondPage.presentation

import com.example.technicaltask1.login.secondPage.domain.Digit

sealed interface SecondPageState {
    data class Password(
        val one: Digit = Digit(null),
        val two: Digit = Digit(null),
        val three: Digit = Digit(null),
        val four: Digit = Digit(null)
    ) :
        SecondPageState

    data object AllDigitInPassword : SecondPageState

}