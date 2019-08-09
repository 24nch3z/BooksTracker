package ru.s4nchez.bookstracker.presentation.view.cat

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_cat.view.*
import ru.s4nchez.bookstracker.R
import ru.s4nchez.bookstracker.presentation.presenter.cat.CatPresenter
import ru.s4nchez.bookstracker.utils.app
import javax.inject.Inject

class CatFactDialog : DialogFragment(), CatView {

    @Inject
    lateinit var presenter: CatPresenter

    private lateinit var factView: TextView
    private lateinit var progressView: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app.componentManager.rootComponent.inject(this)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = LayoutInflater.from(context!!).inflate(R.layout.dialog_cat, null)

        factView = view.text
        progressView = view.progress_view

        return AlertDialog.Builder(context!!)
                .setView(view)
                .setTitle(R.string.cat_dialog_title)
                .setPositiveButton(R.string.cat_dialog_more_button, null)
                .setNegativeButton(R.string.cat_dialog_exit_button, null)
                .create()
    }

    override fun onStart() {
        super.onStart()
        (dialog as AlertDialog).getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
            presenter.loadFact()
        }
        presenter.bindView(this)
        presenter.loadFact()
    }

    override fun onStop() {
        presenter.unbindView()
        super.onStop()
    }

    override fun showFact(fact: String) {
        factView.text = fact
    }

    override fun showProgress() {
        progressView.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressView.visibility = View.INVISIBLE
    }

    override fun enablePositiveButton() {
        (dialog as AlertDialog).getButton(AlertDialog.BUTTON_POSITIVE).let {
            it.alpha = 1f
            it.isClickable = true
        }
    }

    override fun disablePositiveButton() {
        (dialog as AlertDialog).getButton(AlertDialog.BUTTON_POSITIVE).let {
            it.alpha = 0.3f
            it.isClickable = false
        }
    }

    override fun showError(error: Throwable) {
        showFact(getString(R.string.cat_dialog_error))
    }
}