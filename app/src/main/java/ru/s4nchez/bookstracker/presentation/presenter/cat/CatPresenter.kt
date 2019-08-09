package ru.s4nchez.bookstracker.presentation.presenter.cat

import ru.s4nchez.bookstracker.domain.cat.CatInteractor
import ru.s4nchez.bookstracker.presentation.presenter.common.BasePresenter
import ru.s4nchez.bookstracker.presentation.view.cat.CatView
import ru.s4nchez.bookstracker.utils.applySchedulers

class CatPresenter(private val catInteractor: CatInteractor) : BasePresenter<CatView>() {

    fun loadFact() {
        view?.showProgress()
        view?.disablePositiveButton()

        catInteractor.getCatFact()
                .applySchedulers()
                .doOnTerminate { view?.hideProgress() }
                .subscribe({
                    view?.showFact(it)
                    view?.enablePositiveButton()
                }, {
                    view?.showError(it)
                    view?.disablePositiveButton()
                })
                .addToCompositeDisposable()
    }
}