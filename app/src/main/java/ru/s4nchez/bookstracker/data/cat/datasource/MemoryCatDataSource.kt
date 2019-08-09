package ru.s4nchez.bookstracker.data.cat.datasource

import io.reactivex.Completable
import io.reactivex.Single
import ru.s4nchez.bookstracker.data.cat.model.CatFact

class MemoryCatDataSource : CatDataSource {

    private var list = ArrayList<CatFact>()

    override fun putCatFacts(facts: List<CatFact>): Completable {
        return Completable.fromAction {
            list.clear()
            list.addAll(facts)
        }
    }

    override fun getCatFacts(): Single<List<CatFact>> {
        return Single.create {
            if (list.isEmpty()) {
                it.onError(NullPointerException())
            } else {
                it.onSuccess(list)
            }
        }
    }
}