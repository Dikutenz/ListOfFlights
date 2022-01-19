package com.example.listofflights.di

import com.example.listofflights.model.repositories.FlightRepository
import org.koin.dsl.module

val repoModule = module {
    single { FlightRepository(get()) }
}