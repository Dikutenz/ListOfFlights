package com.example.listofflights.di

import com.example.listofflights.viewmodels.FlightViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { FlightViewModel(get()) }
}