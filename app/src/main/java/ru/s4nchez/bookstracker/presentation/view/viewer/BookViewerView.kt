package ru.s4nchez.bookstracker.presentation.view.viewer

import ru.s4nchez.bookstracker.data.book.model.Book
import ru.s4nchez.bookstracker.presentation.view.common.view.BaseView

interface BookViewerView : BaseView {
    fun render(book: Book)
}