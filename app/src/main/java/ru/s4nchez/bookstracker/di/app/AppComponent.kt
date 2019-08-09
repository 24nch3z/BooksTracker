package ru.s4nchez.bookstracker.di.app

import dagger.Component
import ru.s4nchez.bookstracker.di.book.BookModule
import ru.s4nchez.bookstracker.di.cat.CatModule
import ru.s4nchez.bookstracker.presentation.view.authorization.AuthorizationFragment
import ru.s4nchez.bookstracker.presentation.view.cat.CatFactDialog
import ru.s4nchez.bookstracker.presentation.view.creator.BookCreatorFragment
import ru.s4nchez.bookstracker.presentation.view.list.BooksListFragment
import ru.s4nchez.bookstracker.presentation.view.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    PresentersModule::class,
    AuthorizationModule::class,
    CatModule::class,
    NetworkModule::class,
    BookModule::class
])
interface AppComponent {
    fun inject(view: MainActivity)
    fun inject(view: AuthorizationFragment)
    fun inject(view: BookCreatorFragment)
    fun inject(view: BooksListFragment)
    fun inject(view: CatFactDialog)
}