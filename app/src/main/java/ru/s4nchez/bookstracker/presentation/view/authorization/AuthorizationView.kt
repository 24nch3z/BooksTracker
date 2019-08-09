package ru.s4nchez.bookstracker.presentation.view.authorization

import ru.s4nchez.bookstracker.presentation.view.common.view.BaseView
import ru.s4nchez.bookstracker.presentation.view.common.view.ProgressView

interface AuthorizationView : BaseView, ProgressView {
    fun showLoginError()
    fun disableInputs()
    fun enableInputs()
}