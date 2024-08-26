package com.example.technicaltask1.search.data

import com.example.technicaltask1.search.domain.Adress
import com.example.technicaltask1.search.domain.Salary
import retrofit2.http.GET
import retrofit2.http.Query

interface SomeApi {
    @GET("/vacancies")
    suspend fun getVacancy(): VacancyResponse
}
