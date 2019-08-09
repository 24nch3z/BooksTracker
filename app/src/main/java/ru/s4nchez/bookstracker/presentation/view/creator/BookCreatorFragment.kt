package ru.s4nchez.bookstracker.presentation.view.creator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.s4nchez.bookstracker.R
import ru.s4nchez.bookstracker.presentation.presenter.creator.BookCreatorPresenter
import ru.s4nchez.bookstracker.utils.app
import javax.inject.Inject

class BookCreatorFragment : Fragment(), BookCreatorView {

    @Inject
    lateinit var presenter: BookCreatorPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app.componentManager.rootComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_creator, container, false)
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