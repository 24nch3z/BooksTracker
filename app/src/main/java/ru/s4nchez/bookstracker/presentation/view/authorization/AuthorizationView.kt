package ru.s4nchez.bookstracker.presentation.view.authorization

import ru.s4nchez.bookstracker.presentation.view.common.BaseView
import ru.s4nchez.bookstracker.presentation.view.common.ProgressView

interface AuthorizationView : BaseView, ProgressView {
    fun showLoginError()
    fun disableInputs()
    fun enableInputs()
}