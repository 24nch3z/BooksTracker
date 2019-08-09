package ru.s4nchez.bookstracker.di

import android.content.Context
import ru.s4nchez.bookstracker.di.app.AppComponent
import ru.s4nchez.bookstracker.di.app.AppModule
import ru.s4nchez.bookstracker.di.app.DaggerAppComponent
import ru.terrakok.cicerone.Router

class ComponentManager(private val context: Context, private val router: Router) {

    val rootComponent: AppComponent = buildAppComponent()

    private fun buildAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(context, router))
                .build()
    }
}