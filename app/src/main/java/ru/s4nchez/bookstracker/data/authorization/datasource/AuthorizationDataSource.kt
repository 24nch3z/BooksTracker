package ru.s4nchez.bookstracker.data.authorization.datasource

import io.reactivex.Single

interface AuthorizationDataSource {
    fun login(login: String, password: String): Single<Boolean>
}