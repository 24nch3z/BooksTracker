package ru.s4nchez.bookstracker.data.cat.model

import com.google.gson.annotations.SerializedName

data class CatFact(
        @SerializedName("text")
        val text: String
)