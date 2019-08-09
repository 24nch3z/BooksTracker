package ru.s4nchez.bookstracker.presentation.view.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_authorization.*
import ru.s4nchez.bookstracker.R
import ru.s4nchez.bookstracker.presentation.presenter.authorization.AuthorizationPresenter
import ru.s4nchez.bookstracker.utils.app
import ru.s4nchez.bookstracker.utils.snackbar
import javax.inject.Inject

class AuthorizationFragment : Fragment(), AuthorizationView {

    @Inject
    lateinit var presenter: AuthorizationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app.componentManager.rootComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_authorization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login_button.setOnClickListener {
            presenter.login(
                    login_input.text.toString(),
                    password_input.text.toString()
            )
        }

        presenter.bindView(this)
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

    override fun disableInputs() {
        login_input.isClickable = false
        password_input.isClickable = false
        login_button.isClickable = false
        login_input.isEnabled = false
        password_input.isEnabled = false
        login_container.alpha = 0.3f
        password_container.alpha = 0.3f
        login_button.alpha = 0.3f
    }

    override fun enableInputs() {
        login_input.isClickable = true
        password_input.isClickable = true
        login_button.isClickable = true
        login_input.isEnabled = true
        password_input.isEnabled = true
        login_container.alpha = 1f
        password_container.alpha = 1f
        login_button.alpha = 1f
    }

    override fun showLoginError() {
        Snackbar.make(activity!!.findViewById<View>(android.R.id.content),
                R.string.authorization_screen_login_error, Snackbar.LENGTH_SHORT).show()
    }

    override fun showError(error: Throwable) {
        snackbar(R.string.common_error)
    }
}