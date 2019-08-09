package ru.s4nchez.bookstracker.domain.cat.interactor

import io.reactivex.Single
import ru.s4nchez.bookstracker.domain.cat.CatRepository
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