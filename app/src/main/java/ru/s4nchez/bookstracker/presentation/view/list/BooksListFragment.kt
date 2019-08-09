package ru.s4nchez.bookstracker.presentation.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_list.*
import ru.s4nchez.bookstracker.R
import ru.s4nchez.bookstracker.presentation.presenter.list.BooksListPresenter
import ru.s4nchez.bookstracker.presentation.view.common.adaper.AdapterListener
import ru.s4nchez.bookstracker.presentation.view.common.adaper.DiffAdapter
import ru.s4nchez.bookstracker.presentation.view.common.adaper.ListItem
import ru.s4nchez.bookstracker.presentation.view.common.adaper.RecyclerItemClickListener
import ru.s4nchez.bookstracker.presentation.view.list.adapter.BookDelegate
import ru.s4nchez.bookstracker.utils.app
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
        Snackbar.make(activity!!.findViewById<View>(android.R.id.content),
                R.string.common_error, Snackbar.LENGTH_SHORT).show()
    }
}