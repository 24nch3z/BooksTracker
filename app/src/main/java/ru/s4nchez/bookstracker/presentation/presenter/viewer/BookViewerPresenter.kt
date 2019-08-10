package ru.s4nchez.bookstracker.presentation.presenter.viewer

import ru.s4nchez.bookstracker.domain.book.interactor.BookInteractor
import ru.s4nchez.bookstracker.presentation.presenter.common.BasePresenter
import ru.s4nchez.bookstracker.presentation.view.common.BookCreatorScreen
import ru.s4nchez.bookstracker.presentation.view.viewer.BookViewerView
import ru.s4nchez.bookstracker.utils.applySchedulers
import ru.terrakok.cicerone.Router

class BookViewerPresenter(
        private val bookInteractor: BookInteractor,
        private val router: Router
) : BasePresenter<BookViewerView>() {

    fun loadBook(bookId: Long) {
        bookInteractor.getBook(bookId)
                .applySchedulers()
                .subscribe({ view?.render(it) }, { view?.showError(it) })
                .addToCompositeDisposable()
    }

    fun deleteBook(bookId: Long) {
        bookInteractor.delete(bookId)
                .applySchedulers()
                .subscribe({ router.exit() }, { view?.showError(it) })
                .addToCompositeDisposable()
    }

    fun openBookCreatorScreen(bookId: Long) {
        router.navigateTo(BookCreatorScreen(bookId))
    }
}