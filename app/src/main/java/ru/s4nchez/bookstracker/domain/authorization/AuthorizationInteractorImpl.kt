package ru.s4nchez.bookstracker.domain.authorization

import io.reactivex.Completable
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class AuthorizationInteractorImpl : AuthorizationInteractor {

    override fun isAuthorized(): Single<Boolean> {
        return Single.fromCallable { false }
    }

    override fun login(login: String, password: String): Single<AuthorizationResult> {
        return Single.timer(2, TimeUnit.SECONDS)
                .flatMap {
                    Single
                            .fromCallable {
                                if (Math.random() > 0.5)
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