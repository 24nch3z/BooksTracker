package ru.s4nchez.bookstracker.domain.book

import io.reactivex.Observable
import ru.s4nchez.bookstracker.data.book.model.Book

class BookInteractorImpl(private val repository: BookRepository) : BookInteractor {

    override fun getBooks(): Observable<List<Book>> {
        return repository.getBooks()
    }
}