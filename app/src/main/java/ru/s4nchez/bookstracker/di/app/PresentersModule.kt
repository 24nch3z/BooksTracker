package ru.s4nchez.bookstracker.di.app

import dagger.Module
import dagger.Provides
import ru.s4nchez.bookstracker.presentation.presenter.authorization.AuthorizationPresenter
import ru.s4nchez.bookstracker.presentation.presenter.creator.BookCreatorPresenter
import ru.s4nchez.bookstracker.presentation.presenter.list.BooksListPresenter
import ru.s4nchez.bookstracker.presentation.presenter.main.MainScreenPresenter

@Module
class PresentersModule {

    @Provides
    fun provideAuthorizationPresenter(): AuthorizationPresenter {
        return AuthorizationPresenter()
    }

    @Provides
    fun provideBooksListPresenter(): BooksListPresenter {
        return BooksListPresenter()
    }

    @Provides
    fun provideMainScreenPresenter(): MainScreenPresenter {
        return MainScreenPresenter()
    }

    @Provides
    fun provideBookCreatorPresenter(): BookCreatorPresenter {
        return BookCreatorPresenter()
    }
}