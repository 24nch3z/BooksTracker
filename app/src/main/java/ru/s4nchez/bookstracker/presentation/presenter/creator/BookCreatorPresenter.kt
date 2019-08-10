package ru.s4nchez.bookstracker.presentation.presenter.creator

import ru.s4nchez.bookstracker.data.book.model.Book
import ru.s4nchez.bookstracker.domain.book.interactor.BookInteractor
import ru.s4nchez.bookstracker.presentation.presenter.common.BasePresenter
import ru.s4nchez.bookstracker.presentation.view.common.BookViewerScreen
import ru.s4nchez.bookstracker.presentation.view.creator.BookCreatorView
import ru.s4nchez.bookstracker.utils.applySchedulers
import ru.terrakok.cicerone.Router

class BookCreatorPresenter(
        private val bookInteractor: BookInteractor,
        private val router: Router
) : BasePresenter<BookCreatorView>() {

    fun loadBook(bookId: Long) {
        bookInteractor.getBook(bookId)
                .applySchedulers()
                .subscribe({ view?.fillInputs(it) }, { view?.showError(it) })
                .addToCompositeDisposable()
    }

    fun saveBook(bookId: Long?, title: String, author: String, description: String) {
        if (title.trim().isEmpty()) {
            view?.showEmptyTitleError()
            return
        }
        if (author.trim().isEmpty()) {
            view?.showEmptyAuthorError()
            return
        }

        val book = Book(
                id = bookId,
                title = title,
                author = author,
                description = description
        )

        bookInteractor.save(book)
                .applySchedulers()
                .subscribe({
                    if (bookId == null) {
                        router.exit()
                    } else {
                        router.replaceScreen(BookViewerScreen(bookId))
                    }
                }, { view?.showError(it) })
                .addToCompositeDisposable()
    }
}