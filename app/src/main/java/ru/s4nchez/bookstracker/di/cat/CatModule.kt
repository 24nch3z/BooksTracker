package ru.s4nchez.bookstracker.di.cat

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.s4nchez.bookstracker.data.cat.datasource.CatDataSource
import ru.s4nchez.bookstracker.data.cat.datasource.MemoryCatDataSource
import ru.s4nchez.bookstracker.data.cat.datasource.NetworkCatDataSource
import ru.s4nchez.bookstracker.data.cat.repository.CatRepositoryImpl
import ru.s4nchez.bookstracker.domain.cat.interactor.CatInteractor
import ru.s4nchez.bookstracker.domain.cat.interactor.CatInteractorImpl
import ru.s4nchez.bookstracker.domain.cat.CatRepository
import javax.inject.Named
import javax.inject.Singleton

@Module
class CatModule {

    companion object {
        private const val MEMORY_CAT_DATA_SOURCE = "MEMORY_CAT_DATA_SOURCE"
        private const val NETWORK_CAT_DATA_SOURCE = "NETWORK_CAT_DATA_SOURCE"
    }

    @Provides
    @Singleton
    @Named(MEMORY_CAT_DATA_SOURCE)
    fun provideMemoryCatDataSource(): CatDataSource {
        return MemoryCatDataSource()
    }

    @Provides
    @Singleton
    @Named(NETWORK_CAT_DATA_SOURCE)
    fun provideNetworkCatDataSource(retrofit: Retrofit): CatDataSource {
        return NetworkCatDataSource(retrofit)
    }

    @Provides
    @Singleton
    fun provideCatRepository(
            @Named(MEMORY_CAT_DATA_SOURCE) memory: CatDataSource,
            @Named(NETWORK_CAT_DATA_SOURCE) network: CatDataSource
    ): CatRepository {
        return CatRepositoryImpl(memory, network)
    }

    @Provides
    fun provideCatInteractor(repository: CatRepository): CatInteractor {
        return CatInteractorImpl(repository)
    }
}