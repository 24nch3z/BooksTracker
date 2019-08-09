package ru.s4nchez.bookstracker.domain.authorization.interactor

import io.reactivex.Completable
import io.reactivex.Single
import ru.s4nchez.bookstracker.domain.authorization.model.AuthorizationResult

interface AuthorizationInteractor {
    fun isAuthorized(): Single<Boolean>
    fun login(login: String, password: String): Single<AuthorizationResult>
    fun logout(): Completable
}