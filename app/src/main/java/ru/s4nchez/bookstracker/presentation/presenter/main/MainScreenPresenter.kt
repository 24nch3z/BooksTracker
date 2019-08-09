package ru.s4nchez.bookstracker.presentation.presenter.main

import ru.s4nchez.bookstracker.domain.authorization.AuthorizationInteractor
import ru.s4nchez.bookstracker.presentation.presenter.common.BasePresenter
import ru.s4nchez.bookstracker.presentation.view.common.AuthorizationScreen
import ru.s4nchez.bookstracker.presentation.view.common.BooksListScreen
import ru.s4nchez.bookstracker.presentation.view.main.MainScreenView
import ru.s4nchez.bookstracker.utils.applySchedulers
import ru.terrakok.cicerone.Router

class MainScreenPresenter(
        private val router: Router,
        private val authorizationInteractor: AuthorizationInteractor
) : BasePresenter<MainScreenView>() {

    fun determineScreen() {
        authorizationInteractor.isAuthorized()
                .applySchedulers()
                .subscribe({ isAuthorized ->
                    if (isAuthorized) {
                        router.replaceScreen(BooksListScreen())
                    } else {
                        router.replaceScreen(AuthorizationScreen())
                    }
                }, { view?.showError(it) })
                .addToCompositeDisposable()
    }
}