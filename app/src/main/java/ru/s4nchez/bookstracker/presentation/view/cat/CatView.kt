package ru.s4nchez.bookstracker.presentation.view.cat

import ru.s4nchez.bookstracker.presentation.view.common.BaseView

interface CatView : BaseView {
    fun showFact(fact: String)
}