package com.example.technicaltask1.search.domain

import kotlinx.coroutines.flow.Flow

interface VacancyInteractor {
  suspend fun getVacancy(): Flow<VacancyResponseDomain>
}