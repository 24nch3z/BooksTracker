package ru.s4nchez.bookstracker.domain.authorization.interactor

import io.reactivex.Completable
import io.reactivex.Single
import ru.s4nchez.bookstracker.domain.authorization.AuthorizationRepository
import java.util.concurrent.TimeUnit

class AuthorizationInteractorImpl(
        private val authorizationRepository: AuthorizationRepository
) : AuthorizationInteractor {

    override fun isAuthorized(): Single<Boolean> {
        return authorizationRepository.isAuthorized()
    }

    override fun login(login: String, password: String): Single<Boolean> {
        return Completable.timer(1, TimeUnit.SECONDS)
                .andThen(authorizationRepository.login(login, password))
    }

    override fun logout(): Completable {
        return authorizationRepository.logout()
    }
}