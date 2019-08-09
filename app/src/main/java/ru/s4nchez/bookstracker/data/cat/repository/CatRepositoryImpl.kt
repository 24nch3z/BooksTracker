package ru.s4nchez.bookstracker.data.cat.repository

import io.reactivex.Single
import ru.s4nchez.bookstracker.data.cat.datasource.CatDataSource
import ru.s4nchez.bookstracker.data.cat.model.CatFact
import ru.s4nchez.bookstracker.domain.cat.CatRepository

class CatRepositoryImpl(
        private val memoryDataSource: CatDataSource,
        private val networkDataSource: CatDataSource
) : CatRepository {

    override fun getCatFacts(): Single<List<CatFact>> {
        val fromNetwork = networkDataSource.getCatFacts()
                .flatMapCompletable { memoryDataSource.putCatFacts(it) }
                .andThen(memoryDataSource.getCatFacts())

        return memoryDataSource.getCatFacts()
                .onErrorResumeNext(fromNetwork)
    }
}