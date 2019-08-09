package ru.s4nchez.bookstracker.data.authorization.repository

import io.reactivex.Completable
import io.reactivex.Single
import ru.s4nchez.bookstracker.data.authorization.datasource.AuthorizationDataSource
import ru.s4nchez.bookstracker.domain.authorization.AuthorizationRepository
import ru.s4nchez.bookstracker.utils.SharedPrefHelper
import java.util.*

class AuthorizationRepositoryImpl(
        private val sharedPrefHelper: SharedPrefHelper,
        private val authorizationDataSource: AuthorizationDataSource
) : AuthorizationRepository {

    companion object {
        private const val TOKEN = "authorizationToken"
        private const val TOKEN_COOLDOWN = 1000 * 60 * 25
    }

    override fun isAuthorized(): Single<Boolean> {
        return Single.fromCallable {
            val token = sharedPrefHelper.getLong(TOKEN, -1L)
            if (token == -1L) {
                false
            } else {
                token + TOKEN_COOLDOWN >= Date().time
            }
        }
    }

    override fun login(login: String, password: String): Single<Boolean> {
        return authorizationDataSource.login(login, password)
                .map(::saveToken)
    }

    override fun logout(): Completable {
        return Completable.fromAction { sharedPrefHelper.remove(TOKEN) }
    }

    private fun saveToken(isSuccess: Boolean): Boolean {
        if (isSuccess) {
            sharedPrefHelper.save(TOKEN, Date().time)
        }
        return isSuccess
    }
}