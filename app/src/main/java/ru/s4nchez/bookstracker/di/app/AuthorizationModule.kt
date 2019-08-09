package ru.s4nchez.bookstracker.di.app

import dagger.Module
import dagger.Provides
import ru.s4nchez.bookstracker.domain.authorization.interactor.AuthorizationInteractor
import ru.s4nchez.bookstracker.domain.authorization.interactor.AuthorizationInteractorImpl

@Module
class AuthorizationModule {

    @Provides
    fun provideAuthorizationInteractor(): AuthorizationInteractor {
        return AuthorizationInteractorImpl()
    }
}