package com.example.technicaltask1.search.data.dto

import com.example.technicaltask1.search.domain.ButtonClass
import kotlinx.serialization.SerialName

data class OffersDto(
    @SerialName("id") val id: String?,
    @SerialName("tittle") val tittle: String?,
    @SerialName("link") val link: String?,
    @SerialName("button") val button: ButtonClassDto?
)
