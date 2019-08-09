package ru.s4nchez.bookstracker.presentation.view.creator

import ru.s4nchez.bookstracker.data.book.model.Book
import ru.s4nchez.bookstracker.presentation.view.common.view.BaseView

interface BookCreatorView : BaseView {
    fun fillInputs(book: Book)
    fun showEmptyTitleError()
    fun showEmptyAuthorError()
}