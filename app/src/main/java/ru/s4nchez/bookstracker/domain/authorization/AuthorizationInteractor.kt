package ru.s4nchez.bookstracker.domain.authorization

import io.reactivex.Completable
import io.reactivex.Single

interface AuthorizationInteractor {
    fun isAuthorized(): Single<Boolean>
    fun login(login: String, password: String): Single<AuthorizationResult>
    fun logout(): Completable
}