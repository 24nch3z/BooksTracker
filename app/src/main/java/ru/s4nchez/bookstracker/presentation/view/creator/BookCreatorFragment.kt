package ru.s4nchez.bookstracker.presentation.view.creator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_creator.*
import ru.s4nchez.bookstracker.R
import ru.s4nchez.bookstracker.data.book.model.Book
import ru.s4nchez.bookstracker.presentation.presenter.creator.BookCreatorPresenter
import ru.s4nchez.bookstracker.utils.app
import ru.s4nchez.bookstracker.utils.snackbar
import javax.inject.Inject

class BookCreatorFragment : Fragment(), BookCreatorView {

    @Inject
    lateinit var presenter: BookCreatorPresenter

    private var bookId: Long? = null

    companion object {

        private const val ARG_BOOK_ID = "bookId"

        fun create(): BookCreatorFragment {
            return BookCreatorFragment()
        }

        fun change(bookId: Long): BookCreatorFragment {
            return BookCreatorFragment().apply {
                arguments = Bundle().apply {
                    putLong(ARG_BOOK_ID, bookId)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app.componentManager.rootComponent.inject(this)
        bookId = arguments?.getLong(ARG_BOOK_ID)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_creator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        save_button.setOnClickListener {
            presenter.saveBook(
                    bookId = bookId,
                    title = title_input.text.toString(),
                    author = author_input.text.toString(),
                    description = description_input.text.toString()
            )
        }
        presenter.bindView(this)
        bookId?.let { presenter.loadBook(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unbindView()
    }

    override fun fillInputs(book: Book) {
        title_input.setText(book.title)
        author_input.setText(book.author)
        description_input.setText(book.description)
    }

    override fun showEmptyTitleError() {
        snackbar(R.string.book_creator_error_empty_title)
    }

    override fun showEmptyAuthorError() {
        snackbar(R.string.book_creator_error_empty_author)
    }

    override fun showError(error: Throwable) {
        snackbar(R.string.common_error)
    }
}