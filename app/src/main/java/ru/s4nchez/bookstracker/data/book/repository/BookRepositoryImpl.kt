package ru.s4nchez.bookstracker.data.book.repository

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ru.s4nchez.bookstracker.data.book.model.Book
import ru.s4nchez.bookstracker.data.common.database.AppDatabase
import ru.s4nchez.bookstracker.domain.book.BookRepository

class BookRepositoryImpl(private val database: AppDatabase) : BookRepository {

    override fun getBooks(): Observable<List<Book>> {
        return database.bookDao().getAll()
    }

    override fun getBook(id: Long): Single<Book> {
        return database.bookDao().getById(id)
    }

    override fun insert(book: Book): Single<Long> {
        return database.bookDao().insert(book)
    }

    override fun update(book: Book): Single<Long> {
        return database.bookDao().update(book)
                .andThen(Single.fromCallable { book.id!! })
    }

    override fun delete(bookId: Long): Completable {
        return database.bookDao().deleteById(bookId)
    }
}