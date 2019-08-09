package ru.s4nchez.bookstracker.di.app

import dagger.Module
import dagger.Provides
import ru.s4nchez.bookstracker.domain.authorization.interactor.AuthorizationInteractor
import ru.s4nchez.bookstracker.domain.book.interactor.BookInteractor
import ru.s4nchez.bookstracker.domain.cat.interactor.CatInteractor
import ru.s4nchez.bookstracker.presentation.presenter.authorization.AuthorizationPresenter
import ru.s4nchez.bookstracker.presentation.presenter.cat.CatPresenter
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
    fun provideBooksListPresenter(
            router: Router,
            bookInteractor: BookInteractor
    ): BooksListPresenter {
        return BooksListPresenter(router, bookInteractor)
    }

    @Provides
    fun provideMainScreenPresenter(
            router: Router,
            authorizationInteractor: AuthorizationInteractor
    ): MainScreenPresenter {
        return MainScreenPresenter(router, authorizationInteractor)
    }

    @Provides
    fun provideBookCreatorPresenter(
            router: Router,
            bookInteractor: BookInteractor
    ): BookCreatorPresenter {
        return BookCreatorPresenter(bookInteractor, router)
    }

    @Provides
    fun provideCatPresenter(catInteractor: CatInteractor): CatPresenter {
        return CatPresenter(catInteractor)
    }
}