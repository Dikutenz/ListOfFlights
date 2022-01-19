package com.example.listofflights.model.entity


data class Trip(
    var from: String? = null,
    var to: String? = null,
) {

    fun getSFromAirport() = getSAirport(from)

    fun getSToAirport() = getSAirport(to)

    private fun getSAirport(s: String?) = when (s) {
        "SVO" -> "Шереметьево, Россия, Москва"
        "HND" -> "Haneda, Япония, Токио"
        "NRT" -> "Narita International Airport, Япония, Токио"
        "EWR" -> "Newark Liberty International, США, Ньюарк"
        "DME" -> "Домодедово, Россия, Москва"
        "DOH" -> "Доха, Катар, Доха"
        "JFK" -> "John F Kennedy Intl, США, Нью-Йорк"
        "LHR" -> "Хитроу, Великобритания, Лондон"
        "FRA" -> "Francisco P. V. Y R., Мексика, Лагос-де-Морено"
        else -> ""
    }
}