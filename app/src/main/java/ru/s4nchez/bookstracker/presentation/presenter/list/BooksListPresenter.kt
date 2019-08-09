package ru.s4nchez.bookstracker.presentation.presenter.list

import ru.s4nchez.bookstracker.domain.book.BookInteractor
import ru.s4nchez.bookstracker.presentation.presenter.common.BasePresenter
import ru.s4nchez.bookstracker.presentation.view.list.BooksListView
import ru.s4nchez.bookstracker.presentation.view.list.adapter.BookDelegate
import ru.s4nchez.bookstracker.utils.applySchedulers

class BooksListPresenter(
        private val bookInteractor: BookInteractor
) : BasePresenter<BooksListView>() {

    fun loadBooks() {
        bookInteractor.getBooks()
                .applySchedulers()
                .subscribe({ books ->
                    view?.setItems(books.map {
                        BookDelegate.Model(it.id.toString(), it)
                    })
                }, { view?.showError(it) })
                .addToCompositeDisposable()
    }
}