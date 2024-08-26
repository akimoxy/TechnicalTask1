package com.example.technicaltask1.search.data.dto

import com.example.technicaltask1.search.domain.Adress
import com.example.technicaltask1.search.domain.Experience
import com.example.technicaltask1.search.domain.Salary
import kotlinx.serialization.SerialName

data class VacancyDto(
    @SerialName("id") val id: String?,
    @SerialName("lookingNumber") val lookingNumber: Int?,
    @SerialName("title") val title: String?,
    @SerialName("adress") val adress: AdressDto?,
    @SerialName("company") val company: String?,
    @SerialName("publishedDate") val publishedDate: String,
    @SerialName("isFavorite") val isFavorite: Boolean = false,
    @SerialName("salary") val salary: SalaryDto?,
    @SerialName("schedules") var schedules: List<String>? = null,
    @SerialName("appliedNumber") val appliedNumber: Int,
    @SerialName("description") val description: String,
    @SerialName("responsibilities") val responsibilities: String,
    @SerialName("questions") var questions: List<String>? = null,
    @SerialName("experience")  val experience: ExperienceDto
)
