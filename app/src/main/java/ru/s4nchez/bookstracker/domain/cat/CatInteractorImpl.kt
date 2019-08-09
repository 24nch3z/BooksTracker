package ru.s4nchez.bookstracker.domain.cat

import io.reactivex.Single
import java.util.*

class CatInteractorImpl(private val catRepository: CatRepository) : CatInteractor {

    override fun getCatFact(): Single<String> {
        return catRepository.getCatFacts()
                .flatMap { list ->
                    Single.fromCallable {
                        if (list.isEmpty())
                            "Нет фактов"
                        else
                            list[Random().nextInt(list.size)].text
                    }
                }
    }
}