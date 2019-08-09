package ru.s4nchez.bookstracker.data.common.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.s4nchez.bookstracker.data.book.dao.BookDao
import ru.s4nchez.bookstracker.data.book.model.Book

@Database(entities = [Book::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao

    companion object {
        fun CREATE(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "database")
                    .build()
        }
    }
}