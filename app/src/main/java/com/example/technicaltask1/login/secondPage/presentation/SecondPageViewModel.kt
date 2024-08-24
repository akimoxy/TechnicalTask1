package com.example.technicaltask1.login.secondPage.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.technicaltask1.login.secondPage.domain.Digit
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SecondPageViewModel : ViewModel() {
    private var digitJob: Job? = null
    private val searchLiveData =
        MutableLiveData<SecondPageState>()

    fun getState(): LiveData<SecondPageState> = searchLiveData

init {
    updateState(SecondPageState.Password())
}
    private fun updateState(state: SecondPageState) {
        searchLiveData.value = state
    }

    var digit1: Int? = null
    var digit2: Int? = null
    var digit3: Int? = null
    var digit4: Int? = null

    fun saveDigit1(digit: Int?) {
        digit1 = digit
    }

    fun saveDigit2(digit: Int?) {
        digit2 = digit
    }

    fun saveDigit3(digit: Int?) {
        digit3 = digit
    }

    fun saveDigit4(digit: Int?) {
        digit4 = digit
    }

    fun passwordCheck() {
        //   digitJob!!.cancel()
        //   digitJob = viewModelScope.launch {
        updateState(
            SecondPageState.Password(
                one = Digit(digit1),
                two = Digit(digit2),
                three = Digit(digit3),
                four = Digit(digit4)
            )
        )
        if (digit1 != null && digit2 != null && digit3 != null && digit4 != null) {
            updateState(SecondPageState.AllDigitInPassword)
        }
        //     }/
    }
}