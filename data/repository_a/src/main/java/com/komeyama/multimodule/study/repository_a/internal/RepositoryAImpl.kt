package com.komeyama.multimodule.study.repository_a.internal

import com.komeyama.multimodule.study.db_a.DataBaseA
import com.komeyama.multimodule.study.repository_a.RepositoryA
import dagger.Module
import dagger.Provides
import timber.log.Timber

internal class RepositoryAImpl(private val dataBaseA: DataBaseA) : RepositoryA {
    override fun fetch() {
        Timber.d("call fetch")
        Timber.d("fetch info: ${dataBaseA.info()}")
    }
}

@Module
class RepositoryAModule {

    @Provides
    fun provideRepositoryAImpl(dataBaseA: DataBaseA): RepositoryA {
        return RepositoryAImpl(dataBaseA)
    }
}