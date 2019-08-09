package ru.s4nchez.bookstracker.domain.book.interactor

import io.reactivex.Observable
import io.reactivex.Single
import ru.s4nchez.bookstracker.data.book.model.Book
import ru.s4nchez.bookstracker.domain.book.BookRepository

class BookInteractorImpl(private val repository: BookRepository) : BookInteractor {

    override fun getBooks(): Observable<List<Book>> {
        return repository.getBooks()
    }

    override fun getBook(id: Long): Single<Book> {
        return repository.getBook(id)
    }

    override fun save(book: Book): Single<Long> {
        return if (book.id == null)
            repository.insert(book)
        else
            repository.update(book)
    }
}