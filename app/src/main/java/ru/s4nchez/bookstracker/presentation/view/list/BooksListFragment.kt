package ru.s4nchez.bookstracker.presentation.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.s4nchez.bookstracker.R
import ru.s4nchez.bookstracker.presentation.presenter.list.BooksListPresenter
import ru.s4nchez.bookstracker.utils.app
import javax.inject.Inject

class BooksListFragment : Fragment(), BooksListView {

    @Inject
    lateinit var presenter: BooksListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app.componentManager.rootComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.bindView(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unbindView()
    }
}