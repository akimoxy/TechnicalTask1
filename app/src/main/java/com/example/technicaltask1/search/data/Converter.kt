package com.example.technicaltask1.search.data

import com.example.technicaltask1.search.data.dto.AdressDto
import com.example.technicaltask1.search.data.dto.ExperienceDto
import com.example.technicaltask1.search.data.dto.SalaryDto
import com.example.technicaltask1.search.data.dto.VacancyDto
import com.example.technicaltask1.search.domain.Adress
import com.example.technicaltask1.search.domain.Experience
import com.example.technicaltask1.search.domain.Salary
import com.example.technicaltask1.search.domain.Vacancy

class Converter {

    fun mapToVacancy(vacancyDto: VacancyDto): Vacancy {
        return Vacancy(
            id = vacancyDto.id,
            lookingNumber = vacancyDto.lookingNumber,
            title = vacancyDto.title,
            adress = mapToAdress(vacancyDto.adress),
            company = vacancyDto.company,
            publishedDate = vacancyDto.publishedDate,
            isFavorite = vacancyDto.isFavorite,
            salary = mapToSalary(vacancyDto.salary),
            schedules = vacancyDto.schedules,
            appliedNumber = vacancyDto.appliedNumber,
            description = vacancyDto.description,
            responsibilities = vacancyDto.responsibilities,
            questions = vacancyDto.questions,
            experience = mapToExperience(vacancyDto.experience)
        )

    }

    private fun mapToAdress(adressDto: AdressDto?): Adress? {
        return if (adressDto != null)
            Adress(adressDto!!.town, adressDto!!.street, adressDto!!.house)
        else null
    }

    private fun mapToSalary(salaryDto: SalaryDto?): Salary? {
        return if (salaryDto != null) Salary(salaryDto!!.short, salaryDto!!.full)
        else null
    }

    private fun mapToExperience(experienceDto: ExperienceDto?): Experience?{
        return if (experienceDto != null)
            Experience(previewText = experienceDto.text, text = experienceDto.text)
        else null
    }
}