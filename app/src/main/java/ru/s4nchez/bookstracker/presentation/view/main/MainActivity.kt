package ru.s4nchez.bookstracker.presentation.view.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import ru.s4nchez.bookstracker.R
import ru.s4nchez.bookstracker.presentation.presenter.main.MainScreenPresenter
import ru.s4nchez.bookstracker.utils.app
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainScreenView {

    @Inject
    lateinit var presenter: MainScreenPresenter

    private val navigator = SupportAppNavigator(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        app.componentManager.rootComponent.inject(this)
        presenter.bindView(this)
        presenter.determineScreen()
    }

    override fun onResume() {
        super.onResume()
        app.getNavigatorHolder().setNavigator(navigator)
    }

    override fun onStop() {
        app.getNavigatorHolder().removeNavigator()
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

    override fun showError(error: Throwable) {
        Snackbar.make(findViewById<View>(android.R.id.content),
                R.string.common_error, Snackbar.LENGTH_SHORT).show()
    }
}
