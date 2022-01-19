package com.example.listofflights.di

import com.example.listofflights.model.RetrofitClient
import com.example.listofflights.model.RetrofitServices
import org.koin.dsl.module

private const val BASE_URL = "https://603e34c648171b0017b2ec55.mockapi.io"
private fun provideRetrofit() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)

val appModule = module {
    single { provideRetrofit() }
}