package com.komeyama.multimodule.study.corecomponent.di

import android.content.Context
import com.komeyama.multimodule.study.repository_a.RepositoryA
import com.komeyama.multimodule.study.repository_a.RepositoryAComponent
import com.komeyama.multimodule.study.usecase_a.UseCaseA
import com.komeyama.multimodule.study.usecase_a.UseCaseAComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideUseCaseA(
        useCaseAComponent: UseCaseAComponent
    ): UseCaseA {
        return useCaseAComponent.useCaseA()
    }

    @Singleton
    @Provides
    fun provideUseCaseAComponent(repositoryA: RepositoryA): UseCaseAComponent {
        return UseCaseAComponent.factory().create(context, repositoryA)
    }

    @Singleton
    @Provides
    fun provideRepositoryA(
        repositoryAComponent: RepositoryAComponent
    ): RepositoryA {
        return repositoryAComponent.repositoryA()
    }

    @Singleton
    @Provides
    fun provideRepositoryAComponent(): RepositoryAComponent {
        return RepositoryAComponent.factory().create()
    }
}
