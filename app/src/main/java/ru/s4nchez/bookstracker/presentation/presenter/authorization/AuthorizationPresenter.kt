package ru.s4nchez.bookstracker.presentation.presenter.authorization

import ru.s4nchez.bookstracker.domain.authorization.interactor.AuthorizationInteractor
import ru.s4nchez.bookstracker.domain.authorization.model.AuthorizationResult
import ru.s4nchez.bookstracker.presentation.presenter.common.BasePresenter
import ru.s4nchez.bookstracker.presentation.view.authorization.AuthorizationView
import ru.s4nchez.bookstracker.presentation.view.common.BooksListScreen
import ru.s4nchez.bookstracker.utils.applySchedulers
import ru.terrakok.cicerone.Router

class AuthorizationPresenter(
        private val router: Router,
        private val authorizationInteractor: AuthorizationInteractor
) : BasePresenter<AuthorizationView>() {

    fun login(login: String, password: String) {
        view?.showProgress()
        view?.disableInputs()

        authorizationInteractor.login(login, password)
                .applySchedulers()
                .doOnTerminate { view?.hideProgress() }
                .subscribe({ result ->
                    when (result) {
                        AuthorizationResult.SUCCESS -> router.replaceScreen(BooksListScreen())
                        AuthorizationResult.ERROR -> {
                            view?.showLoginError()
                            view?.enableInputs()
                        }
                    }
                }, {
                    view?.enableInputs()
                    view?.showError(it)
                })
                .addToCompositeDisposable()
    }
}