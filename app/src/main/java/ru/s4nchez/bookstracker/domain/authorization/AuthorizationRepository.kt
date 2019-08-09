package ru.s4nchez.bookstracker.domain.authorization

import io.reactivex.Completable
import io.reactivex.Single

interface AuthorizationRepository {
    fun isAuthorized(): Single<Boolean>
    fun login(login: String, password: String): Single<Boolean>
    fun logout(): Completable
}