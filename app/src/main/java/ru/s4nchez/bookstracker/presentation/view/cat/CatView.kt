package ru.s4nchez.bookstracker.presentation.view.cat

import ru.s4nchez.bookstracker.presentation.view.common.view.BaseView
import ru.s4nchez.bookstracker.presentation.view.common.view.ProgressView

interface CatView : BaseView, ProgressView {
    fun showFact(fact: String)
    fun enablePositiveButton()
    fun disablePositiveButton()
}