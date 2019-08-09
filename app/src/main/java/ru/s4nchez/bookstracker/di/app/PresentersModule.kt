package ru.s4nchez.bookstracker.di.app

import dagger.Module
import dagger.Provides
import ru.s4nchez.bookstracker.domain.authorization.AuthorizationInteractor
import ru.s4nchez.bookstracker.presentation.presenter.authorization.AuthorizationPresenter
import ru.s4nchez.bookstracker.presentation.presenter.creator.BookCreatorPresenter
import ru.s4nchez.bookstracker.presentation.presenter.list.BooksListPresenter
import ru.s4nchez.bookstracker.presentation.presenter.main.MainScreenPresenter
import ru.terrakok.cicerone.Router

@Module
class PresentersModule {

    @Provides
    fun provideAuthorizationPresenter(
            router: Router,
            authorizationInteractor: AuthorizationInteractor
    ): AuthorizationPresenter {
        return AuthorizationPresenter(router, authorizationInteractor)
    }

    @Provides
    fun provideBooksListPresenter(): BooksListPresenter {
        return BooksListPresenter()
    }

    @Provides
    fun provideMainScreenPresenter(
            router: Router,
            authorizationInteractor: AuthorizationInteractor
    ): MainScreenPresenter {
        return MainScreenPresenter(router, authorizationInteractor)
    }

    @Provides
    fun provideBookCreatorPresenter(): BookCreatorPresenter {
        return BookCreatorPresenter()
    }
}