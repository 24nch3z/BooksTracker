package ru.s4nchez.bookstracker.presentation.view.cat

import ru.s4nchez.bookstracker.presentation.view.common.view.BaseView

interface CatView : BaseView {
    fun showFact(fact: String)
}