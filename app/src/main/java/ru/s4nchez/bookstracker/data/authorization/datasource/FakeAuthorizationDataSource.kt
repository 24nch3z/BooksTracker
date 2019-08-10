package ru.s4nchez.bookstracker.data.authorization.datasource

import io.reactivex.Single

class FakeAuthorizationDataSource : AuthorizationDataSource {

    companion object {
        private val accounts = mapOf(
                "Messi" to "12345",
                "JamesBond" to "007",
                "login" to "password",
                "admin" to "admin",
                "Tarantino" to "django"
        )
    }

    override fun login(login: String, password: String): Single<Boolean> {
        return Single.fromCallable { accounts.containsKey(login) && accounts[login] == password }
    }
}