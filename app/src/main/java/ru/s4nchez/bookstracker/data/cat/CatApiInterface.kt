package ru.s4nchez.bookstracker.data.cat

import retrofit2.Call
import retrofit2.http.GET
import ru.s4nchez.bookstracker.data.cat.model.CatResponse

const val BASE_URL = "https://cat-fact.herokuapp.com/"

interface CatApiInterface {

    @GET("facts")
    fun getFacts(): Call<CatResponse>
}