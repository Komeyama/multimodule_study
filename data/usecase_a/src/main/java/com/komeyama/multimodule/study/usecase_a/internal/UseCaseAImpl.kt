package com.komeyama.multimodule.study.usecase_a.internal

import android.content.Context
import com.komeyama.multimodule.study.repository_a.RepositoryA
import com.komeyama.multimodule.study.usecase_a.UseCaseA
import dagger.Module
import dagger.Provides
import timber.log.Timber
import javax.inject.Inject

internal class UseCaseAImpl @Inject constructor(
    private val context: Context,
    private val repositoryA: RepositoryA
) : UseCaseA {
    override fun serviceA1() {
        Timber.d("call serviceA1, package name:${context.packageName}")
        repositoryA.fetch()
    }
}

@Module
class UseCaseAModule {

    @Provides
    fun provideUseCaseAImpl(context: Context, repositoryA: RepositoryA): UseCaseA {
        return UseCaseAImpl(context, repositoryA)
    }
}