package ru.s4nchez.bookstracker.domain.authorization.interactor

import io.reactivex.Completable
import io.reactivex.Single

interface AuthorizationInteractor {
    fun isAuthorized(): Single<Boolean>
    fun login(login: String, password: String): Single<Boolean>
    fun logout(): Completable
}