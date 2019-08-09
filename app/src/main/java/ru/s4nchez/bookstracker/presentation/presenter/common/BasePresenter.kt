package ru.s4nchez.bookstracker.presentation.presenter.common

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter<T> {

    protected var view: T? = null
    private var disposable = CompositeDisposable()

    open fun bindView(view: T) {
        if (view == null) {
            throw IllegalArgumentException("view не может быть null")
        }
        this.view = view
    }

    open fun unbindView() {
        view = null
        disposable.clear()
    }

    fun Disposable.addToCompositeDisposable() {
        disposable.add(this)
    }
}