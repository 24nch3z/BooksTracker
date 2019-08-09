package ru.s4nchez.bookstracker.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.s4nchez.bookstracker.data.common.database.AppDatabase
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class AppModule(private val context: Context, private val router: Router) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideRouter(): Router {
        return router
    }

    @Provides
    @Singleton
    fun provideDatabase(): AppDatabase {
        return AppDatabase.create(context)
    }
}