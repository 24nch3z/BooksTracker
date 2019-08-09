package ru.s4nchez.bookstracker.data.cat.datasource

import io.reactivex.Completable
import io.reactivex.Single
import ru.s4nchez.bookstracker.data.cat.model.CatFact

interface CatDataSource {
    fun getCatFacts(): Single<List<CatFact>>
    fun putCatFacts(facts: List<CatFact>): Completable
}