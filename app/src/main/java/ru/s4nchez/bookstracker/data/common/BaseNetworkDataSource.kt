package ru.s4nchez.bookstracker.data.common

import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import java.io.IOException

abstract class BaseNetworkDataSource {

    fun <T> makeRequest(call: Call<T>): Single<T> {
        return Single.create { emitter ->
            try {
                val response = call.execute()
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    responseBody?.let { emitter.onSuccess(it) }
                } else {
                    emitter.onError(handleError(response))
                }
            } catch (e: IOException) {
                if (!emitter.isDisposed)
                    emitter.onError(e)
            }
        }
    }

    abstract fun <T> handleError(response: Response<T>): Exception
}