package com.example.technicaltask1.search.data.dto

import kotlinx.serialization.SerialName

data class ExperienceDto(
    @SerialName("previewText") val previewText:String?,
    @SerialName("text") val text:String? )
