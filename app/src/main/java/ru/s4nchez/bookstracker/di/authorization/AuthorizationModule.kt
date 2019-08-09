package ru.s4nchez.bookstracker.di.authorization

import dagger.Module
import dagger.Provides
import ru.s4nchez.bookstracker.data.authorization.datasource.AuthorizationDataSource
import ru.s4nchez.bookstracker.data.authorization.datasource.FakeAuthorizationDataSource
import ru.s4nchez.bookstracker.data.authorization.repository.AuthorizationRepositoryImpl
import ru.s4nchez.bookstracker.domain.authorization.AuthorizationRepository
import ru.s4nchez.bookstracker.domain.authorization.interactor.AuthorizationInteractor
import ru.s4nchez.bookstracker.domain.authorization.interactor.AuthorizationInteractorImpl
import ru.s4nchez.bookstracker.utils.SharedPrefHelper
import javax.inject.Singleton

@Module
class AuthorizationModule {

    @Provides
    @Singleton
    fun provideAuthorizationDataSource(): AuthorizationDataSource {
        return FakeAuthorizationDataSource()
    }

    @Provides
    @Singleton
    fun provideAuthorizationRepository(
            sharedPrefHelper: SharedPrefHelper,
            authorizationDataSource: AuthorizationDataSource
    ): AuthorizationRepository {
        return AuthorizationRepositoryImpl(sharedPrefHelper, authorizationDataSource)
    }

    @Provides
    fun provideAuthorizationInteractor(
            authorizationRepository: AuthorizationRepository
    ): AuthorizationInteractor {
        return AuthorizationInteractorImpl(authorizationRepository)
    }
}