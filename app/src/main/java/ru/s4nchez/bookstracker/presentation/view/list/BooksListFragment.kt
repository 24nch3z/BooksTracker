package ru.s4nchez.bookstracker.presentation.view.list

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_list.*
import ru.s4nchez.bookstracker.R
import ru.s4nchez.bookstracker.presentation.presenter.list.BooksListPresenter
import ru.s4nchez.bookstracker.presentation.view.cat.CatFactDialog
import ru.s4nchez.bookstracker.presentation.view.common.adaper.AdapterListener
import ru.s4nchez.bookstracker.presentation.view.common.adaper.DiffAdapter
import ru.s4nchez.bookstracker.presentation.view.common.adaper.ListItem
import ru.s4nchez.bookstracker.presentation.view.common.adaper.RecyclerItemClickListener
import ru.s4nchez.bookstracker.presentation.view.list.adapter.BookDelegate
import ru.s4nchez.bookstracker.utils.app
import ru.s4nchez.bookstracker.utils.snackbar
import javax.inject.Inject

class BooksListFragment : Fragment(), BooksListView, RecyclerItemClickListener, AdapterListener {

    @Inject
    lateinit var presenter: BooksListPresenter

    private val bookAdapter by lazy {
        DiffAdapter(listOf(BookDelegate(this)), this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app.componentManager.rootComponent.inject(this)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.adapter = bookAdapter
        presenter.bindView(this)
        presenter.loadBooks()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unbindView()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.book_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_item_cat) {
            val dialog = CatFactDialog()
            dialog.show(fragmentManager, null)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showProgress() {
        progress_view.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_view.visibility = View.INVISIBLE
    }

    override fun showEmptyListView() {
        empty_list_View.visibility = View.VISIBLE
    }

    override fun hideEmptyListView() {
        empty_list_View.visibility = View.INVISIBLE
    }

    override fun setItems(items: List<ListItem>) {
        bookAdapter.items = items
    }

    override fun onClick(listItem: ListItem) {
        Toast.makeText(context!!, "Книга выбрана", Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: Throwable) {
        snackbar(R.string.common_error)
    }
}