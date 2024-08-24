package com.example.technicaltask1.di

import com.example.technicaltask1.login.secondPage.presentation.SecondPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
val presentationModule = module {
    viewModel<SecondPageViewModel> { SecondPageViewModel() }
}