package com.example.technicaltask1.di

import android.content.Context
import com.example.technicaltask1.search.data.Converter
import com.example.technicaltask1.search.data.NetworkClient
import com.example.technicaltask1.search.data.RetrofitNetworkClient
import com.example.technicaltask1.search.data.SomeApi
import com.example.technicaltask1.search.data.VacancyRepositoryImpl
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    //   single {
    ///      androidContext().getSharedPreferences(FUTUREJOB_SHARED_PREFS, Context.MODE_PRIVATE)
    //  }
    factory { Gson() }
    single<NetworkClient> {
        RetrofitNetworkClient(someApi = get())
    }

    single<SomeApi> {
        Retrofit.Builder()
            .baseUrl("https://drive.usercontent.google.com/u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SomeApi::class.java)
    }
    factory { Converter() }
    factory<VacancyRepositoryImpl> {
        VacancyRepositoryImpl(networkClient = get(), converter = get())
    }
}
