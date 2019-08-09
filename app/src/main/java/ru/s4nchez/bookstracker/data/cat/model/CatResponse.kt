package ru.s4nchez.bookstracker.data.cat.model

import com.google.gson.annotations.SerializedName

data class CatResponse(
        @SerializedName("all")
        val facts: List<CatFact>
)