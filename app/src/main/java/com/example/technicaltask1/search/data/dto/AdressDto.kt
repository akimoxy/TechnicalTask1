package com.example.technicaltask1.search.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class AdressDto(
    @SerialName("town") val town: String?,
    @SerialName("street") val street: String?,
    @SerialName("house") val house: String?
)