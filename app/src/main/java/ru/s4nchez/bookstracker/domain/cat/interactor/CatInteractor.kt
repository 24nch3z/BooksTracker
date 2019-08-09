package ru.s4nchez.bookstracker.domain.cat.interactor

import io.reactivex.Single

interface CatInteractor {
    fun getCatFact(): Single<String>
}