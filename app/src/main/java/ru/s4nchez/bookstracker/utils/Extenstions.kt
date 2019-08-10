package ru.s4nchez.bookstracker.utils

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.s4nchez.bookstracker.MyApp

val Activity.app: MyApp
    get() = this.application as MyApp

val Fragment.app: MyApp
    get() = this.activity?.app!!

fun <T> Single<T>.applySchedulers(): Single<T> {
    return this
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.applySchedulers(): Observable<T> {
    return this
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

fun Completable.applySchedulers(): Completable {
    return this
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

fun ViewGroup.inflate(@LayoutRes layout: Int): View {
    return LayoutInflater.from(this.context).inflate(layout, this, false)
}

fun Fragment.snackbar(@StringRes resId: Int) {
    activity?.snackbar(resId)
}

fun Activity.snackbar(@StringRes resId: Int) {
    Snackbar.make(findViewById<View>(android.R.id.content),
            resId, Snackbar.LENGTH_SHORT).show()
}