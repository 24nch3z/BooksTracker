package ru.s4nchez.bookstracker.presentation.view.common

import androidx.fragment.app.Fragment
import ru.s4nchez.bookstracker.presentation.view.authorization.AuthorizationFragment
import ru.s4nchez.bookstracker.presentation.view.creator.BookCreatorFragment
import ru.s4nchez.bookstracker.presentation.view.list.BooksListFragment
import ru.s4nchez.bookstracker.presentation.view.viewer.BookViewerFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class AuthorizationScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return AuthorizationFragment()
    }
}

class BooksListScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return BooksListFragment()
    }
}

class BookCreatorCreateScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return BookCreatorFragment.create()
    }
}

class BookCreatorChangeScreen(private val bookId: Long) : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return BookCreatorFragment.change(bookId)
    }
}

class BookViewerScreen(private val bookId: Long) : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return BookViewerFragment.newInstance(bookId)
    }
}