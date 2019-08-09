package ru.s4nchez.bookstracker.presentation.view.viewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_book_viewer.*
import ru.s4nchez.bookstracker.R
import ru.s4nchez.bookstracker.data.book.model.Book
import ru.s4nchez.bookstracker.presentation.presenter.viewer.BookViewerPresenter
import ru.s4nchez.bookstracker.utils.app
import ru.s4nchez.bookstracker.utils.snackbar
import javax.inject.Inject

class BookViewerFragment : Fragment(), BookViewerView {

    @Inject
    lateinit var presenter: BookViewerPresenter

    private var bookId: Long? = null

    companion object {
        private const val ARG_BOOK_ID = "bookId"

        fun newInstance(bookId: Long): BookViewerFragment {
            return BookViewerFragment().apply {
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
        return inflater.inflate(R.layout.fragment_book_viewer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.bindView(this)
        presenter.loadBook(bookId!!)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unbindView()
    }

    override fun render(book: Book) {
        content.visibility = View.VISIBLE
        title_view.text = book.title
        author_view.text = book.author
        if (book.description.trim().isNotEmpty()) {
            description_view.text = book.description
            description_view.visibility = View.VISIBLE
            description_label_view.visibility = View.VISIBLE
        } else {
            description_view.visibility = View.GONE
            description_label_view.visibility = View.GONE
        }
    }

    override fun showError(error: Throwable) {
        snackbar(R.string.common_error)
    }
}