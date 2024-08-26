package com.example.technicaltask1.search.domain

import kotlinx.coroutines.flow.Flow

interface VacancyRepository {
 suspend fun getVacancy(): Flow<VacancyResponseDomain>
}