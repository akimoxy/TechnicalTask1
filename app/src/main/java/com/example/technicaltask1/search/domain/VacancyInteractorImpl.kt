package com.example.technicaltask1.search.domain

import kotlinx.coroutines.flow.Flow

class VacancyInteractorImpl(private val vacancyRepository: VacancyRepository) : VacancyInteractor {
    override suspend fun getVacancy(): Flow<VacancyResponseDomain> {
        return vacancyRepository.getVacancy()
    }
}