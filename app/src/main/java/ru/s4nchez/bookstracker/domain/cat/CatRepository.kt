package ru.s4nchez.bookstracker.domain.cat

import io.reactivex.Single
import ru.s4nchez.bookstracker.data.cat.model.CatFact

interface CatRepository {
    fun getCatFacts(): Single<List<CatFact>>
}