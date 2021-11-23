package com.komeyama.multimodule.study.repository_a.internal

import com.komeyama.multimodule.study.repository_a.RepositoryA
import dagger.Module
import dagger.Provides
import timber.log.Timber

internal class RepositoryAImpl : RepositoryA {
    override fun fetch() {
        Timber.d("call fetch")
    }
}

@Module
class RepositoryAModule {

    @Provides
    fun provideRepositoryAImpl(): RepositoryA {
        return RepositoryAImpl()
    }
}