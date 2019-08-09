package ru.s4nchez.bookstracker.presentation.view.authorization

import ru.s4nchez.bookstracker.presentation.presenter.common.BaseView

interface AuthorizationView : BaseView {
    fun showLoginError()
    fun showProgress()
    fun hideProgress()
    fun disableInputs()
    fun enableInputs()
}