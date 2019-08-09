package ru.s4nchez.bookstracker.data.cat.datasource

import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.Retrofit
import ru.s4nchez.bookstracker.data.cat.CatApiInterface
import ru.s4nchez.bookstracker.data.cat.model.CatFact
import ru.s4nchez.bookstracker.data.common.BaseNetworkDataSource

class NetworkCatDataSource(retrofit: Retrofit) : BaseNetworkDataSource(), CatDataSource {

    private val api = retrofit.create(CatApiInterface::class.java)

    override fun getCatFacts(): Single<List<CatFact>> {
        return makeRequest(api.getFacts())
                .map { it.facts }
    }

    override fun putCatFacts(facts: List<CatFact>): Completable {
        throw UnsupportedOperationException()
    }

    override fun <T> handleError(response: Response<T>): Exception {
        return Exception(response.message())
    }
}