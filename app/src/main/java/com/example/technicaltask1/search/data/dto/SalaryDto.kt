package com.example.technicaltask1.search.data.dto

import kotlinx.serialization.SerialName

data class SalaryDto(
    @SerialName("short") val short: String,
    @SerialName("full") val full: String
)
