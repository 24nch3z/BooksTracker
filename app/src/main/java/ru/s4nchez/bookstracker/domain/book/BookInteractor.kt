package ru.s4nchez.bookstracker.domain.book

import io.reactivex.Observable
import ru.s4nchez.bookstracker.data.book.model.Book

interface BookInteractor {
    fun getBooks() : Observable<List<Book>>
}