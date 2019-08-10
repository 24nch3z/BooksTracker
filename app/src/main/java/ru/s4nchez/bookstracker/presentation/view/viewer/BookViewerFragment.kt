package ru.s4nchez.bookstracker.presentation.view.viewer

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_book_viewer.*
import ru.s4nchez.bookstracker.R
import ru.s4nchez.bookstracker.data.book.model.Book
import ru.s4nchez.bookstracker.presentation.presenter.viewer.BookViewerPresenter
import ru.s4nchez.bookstracker.presentation.view.common.dialog.QuestionDialog
import ru.s4nchez.bookstracker.utils.app
import ru.s4nchez.bookstracker.utils.snackbar
import javax.inject.Inject

class BookViewerFragment : Fragment(), BookViewerView, QuestionDialog.DialogListener {

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
        setHasOptionsMenu(true)
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

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.book_viewer_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_delete -> {
                val tag = QuestionDialog::class.java.name
                if (fragmentManager?.findFragmentByTag(tag) == null) {
                    val dialog = QuestionDialog
                            .newInstance(R.string.book_viewer_delete_book_message)
                    dialog.setTargetFragment(this, 0)
                    dialog.isCancelable = false
                    dialog.show(fragmentManager, tag)
                }
                return true
            }
            R.id.menu_item_change -> {
                presenter.openBookCreatorScreen(bookId!!)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
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

    override fun onClickPositive() {
        presenter.deleteBook(bookId!!)
    }

    override fun showError(error: Throwable) {
        snackbar(R.string.common_error)
    }
}