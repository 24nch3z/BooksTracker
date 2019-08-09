package ru.s4nchez.bookstracker.domain.authorization.interactor

import io.reactivex.Completable
import io.reactivex.Single
import ru.s4nchez.bookstracker.domain.authorization.model.AuthorizationResult
import java.util.concurrent.TimeUnit

class AuthorizationInteractorImpl : AuthorizationInteractor {

    override fun isAuthorized(): Single<Boolean> {
        return Single.fromCallable { false }
    }

    override fun login(login: String, password: String): Single<AuthorizationResult> {
        return Single.timer(1, TimeUnit.SECONDS)
                .flatMap {
                    Single
                            .fromCallable {
                                if (Math.random() > 0.1)
                                    AuthorizationResult.SUCCESS
                                else
                                    AuthorizationResult.ERROR
                            }
                }
    }

    override fun logout(): Completable {
        return Completable.complete()
    }
}