package ru.s4nchez.bookstracker.presentation.presenter.authorization

import ru.s4nchez.bookstracker.domain.authorization.AuthorizationInteractor
import ru.s4nchez.bookstracker.presentation.presenter.common.BasePresenter
import ru.s4nchez.bookstracker.presentation.view.authorization.AuthorizationView
import ru.terrakok.cicerone.Router

class AuthorizationPresenter(
        private val router: Router,
        private val authorizationInteractor: AuthorizationInteractor
) : BasePresenter<AuthorizationView>() {


}