package com.komeyama.multimodule.study.usecase_a.internal

import com.komeyama.multimodule.study.repository_a.RepositoryA
import com.komeyama.multimodule.study.usecase_a.UseCaseA
import dagger.Module
import dagger.Provides
import timber.log.Timber

internal class UseCaseAImpl constructor(
    private val repositoryA: RepositoryA
) : UseCaseA {
    override fun serviceA1() {
        Timber.d("call serviceA1")
        repositoryA.fetch()
    }
}

@Module
class UseCaseAModule {

    @Provides
    fun provideUseCaseAImpl(repositoryA: RepositoryA): UseCaseA {
        return UseCaseAImpl(repositoryA)
    }
}