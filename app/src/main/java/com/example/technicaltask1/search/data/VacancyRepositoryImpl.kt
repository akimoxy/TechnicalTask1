package com.example.technicaltask1.search.data

import com.example.technicaltask1.search.domain.VacancyRepository
import com.example.technicaltask1.search.domain.VacancyResponseDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VacancyRepositoryImpl(
    private val networkClient: NetworkClient,
    private val converter: Converter
) : VacancyRepository {
    override suspend fun getVacancy(): Flow<VacancyResponseDomain> = flow {
        val response = networkClient.doRequest()
        if (response.resultCode == SERVER_CODE_200) {
            val listVacancy = (response as VacancyResponse?)!!.results.map {
                converter.mapToVacancy(it)
            }
            emit(VacancyResponseDomain(listVacancy, response.resultCode))
        } else {
            emit(VacancyResponseDomain(emptyList(), response.resultCode))
        }
    }
}
