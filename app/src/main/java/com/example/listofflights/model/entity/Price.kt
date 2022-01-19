package com.example.listofflights.model.entity

data class Price(
    var type: String? = null,
    var amount: Int? = null
) {

    fun getSType() = when (type) {
        "economy" -> "эконом"
        "bussiness" -> "бизнес"
        else -> ""
    }
}