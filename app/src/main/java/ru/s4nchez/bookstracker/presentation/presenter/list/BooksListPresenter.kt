package ru.s4nchez.bookstracker.presentation.presenter.list

import ru.s4nchez.bookstracker.domain.authorization.interactor.AuthorizationInteractor
import ru.s4nchez.bookstracker.domain.book.interactor.BookInteractor
import ru.s4nchez.bookstracker.presentation.presenter.common.BasePresenter
import ru.s4nchez.bookstracker.presentation.view.common.AuthorizationScreen
import ru.s4nchez.bookstracker.presentation.view.common.BookCreatorScreen
import ru.s4nchez.bookstracker.presentation.view.common.BookViewerScreen
import ru.s4nchez.bookstracker.presentation.view.list.BooksListView
import ru.s4nchez.bookstracker.presentation.view.list.adapter.BookDelegate
import ru.s4nchez.bookstracker.utils.applySchedulers
import ru.terrakok.cicerone.Router

class BooksListPresenter(
        private val router: Router,
        private val bookInteractor: BookInteractor,
        private val authorizationInteractor: AuthorizationInteractor
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

    fun openBookCreator() {
        router.navigateTo(BookCreatorScreen())
    }

    fun openBookViewer(bookId: Long) {
        router.navigateTo(BookViewerScreen(bookId))
    }

    fun logout() {
        authorizationInteractor.logout()
                .applySchedulers()
                .subscribe({ router.newRootScreen(AuthorizationScreen()) }, { view?.showError(it) })
                .addToCompositeDisposable()
    }
}