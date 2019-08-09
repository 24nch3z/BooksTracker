package ru.s4nchez.bookstracker.data.book.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Observable
import io.reactivex.Single
import ru.s4nchez.bookstracker.data.book.model.Book
import ru.s4nchez.bookstracker.data.common.database.dao.BaseDao

@Dao
interface BookDao : BaseDao<Book> {

    @Query("SELECT * FROM BookTable")
    fun getAll(): Observable<List<Book>>

    @Query("SELECT * FROM BookTable WHERE id = :bookId")
    fun getById(bookId: Long): Single<Book>

    @Query("DELETE FROM BookTable WHERE id = :bookId")
    fun deleteById(bookId: Long)
}