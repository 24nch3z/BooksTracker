package ru.s4nchez.bookstracker.presentation.view.common.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import ru.s4nchez.bookstracker.R

class QuestionDialog : DialogFragment() {

    private lateinit var listener: DialogListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = targetFragment as DialogListener
        } catch (error: ClassCastException) {
            throw ClassCastException()
        }
    }

    companion object {
        private const val ARG_MESSAGE = "message"

        fun newInstance(@StringRes message: Int): QuestionDialog {
            return QuestionDialog().apply {
                arguments = Bundle().apply {
                    putInt(ARG_MESSAGE, message)
                }
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(context!!)
                .setMessage(arguments?.getInt(ARG_MESSAGE)!!)
                .setPositiveButton(R.string.yes) { _, _ -> listener.onClickPositive() }
                .setNegativeButton(R.string.cancel) { _, _ -> }
                .create()
    }

    interface DialogListener {
        fun onClickPositive()
    }
}