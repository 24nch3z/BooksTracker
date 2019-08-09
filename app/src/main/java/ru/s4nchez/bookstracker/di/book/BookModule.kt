package ru.s4nchez.bookstracker.di.book

import dagger.Module
import dagger.Provides
import ru.s4nchez.bookstracker.data.book.repository.BookRepositoryImpl
import ru.s4nchez.bookstracker.data.common.database.AppDatabase
import ru.s4nchez.bookstracker.domain.book.BookInteractor
import ru.s4nchez.bookstracker.domain.book.BookInteractorImpl
import ru.s4nchez.bookstracker.domain.book.BookRepository
import javax.inject.Singleton

@Module
class BookModule {

    @Singleton
    @Provides
    fun provideBookRepository(database: AppDatabase): BookRepository {
        return BookRepositoryImpl(database)
    }

    @Singleton
    @Provides
    fun provideBookInteractor(bookRepository: BookRepository): BookInteractor {
        return BookInteractorImpl(bookRepository)
    }
}