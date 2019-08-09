package ru.s4nchez.bookstracker.data.book.repository

import io.reactivex.Observable
import ru.s4nchez.bookstracker.data.book.model.Book
import ru.s4nchez.bookstracker.data.common.database.AppDatabase
import ru.s4nchez.bookstracker.domain.book.BookRepository

class BookRepositoryImpl(private val database: AppDatabase) : BookRepository {

    override fun getBooks(): Observable<List<Book>> {
        return database.bookDao().getAll()
    }
}