package ru.s4nchez.bookstracker.domain.cat

import io.reactivex.Single

interface CatInteractor {
    fun getCatFact(): Single<String>
}