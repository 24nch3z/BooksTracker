package ru.s4nchez.bookstracker.di.app

import dagger.Module
import dagger.Provides
import ru.s4nchez.bookstracker.domain.authorization.AuthorizationInteractor
import ru.s4nchez.bookstracker.domain.authorization.AuthorizationInteractorImpl

@Module
class AuthorizationModule {

    @Provides
    fun provideAuthorizationInteractor(): AuthorizationInteractor {
        return AuthorizationInteractorImpl()
    }
}