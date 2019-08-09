package ru.s4nchez.bookstracker.domain.book

import io.reactivex.Observable
import io.reactivex.Single
import ru.s4nchez.bookstracker.data.book.model.Book

interface BookInteractor {
    fun getBooks(): Observable<List<Book>>
    fun getBook(id: Long): Single<Book>
    fun save(book: Book): Single<Long>
}