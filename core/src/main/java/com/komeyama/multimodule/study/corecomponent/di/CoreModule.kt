package com.komeyama.multimodule.study.corecomponent.di

import android.content.Context
import com.komeyama.multimodule.study.db_a.DataBaseA
import com.komeyama.multimodule.study.db_a.DataBaseAComponent
import com.komeyama.multimodule.study.repository_a.RepositoryA
import com.komeyama.multimodule.study.repository_a.RepositoryAComponent
import com.komeyama.multimodule.study.usecase_a.UseCaseA
import com.komeyama.multimodule.study.usecase_a.UseCaseAComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class  CoreModule(private val context: Context) {

    @Provides
    fun provideUseCaseA(
        useCaseAComponent: UseCaseAComponent
    ): UseCaseA {
        return useCaseAComponent.useCaseA()
    }

    @Provides
    fun provideUseCaseAComponent(repositoryA: RepositoryA): UseCaseAComponent {
        return UseCaseAComponent.factory().create(repositoryA)
    }

    @Provides
    fun provideRepositoryA(
        repositoryAComponent: RepositoryAComponent
    ): RepositoryA {
        return repositoryAComponent.repositoryA()
    }

    @Provides
    fun provideRepositoryAComponent(dataBaseA: DataBaseA): RepositoryAComponent {
        return RepositoryAComponent.factory().create(dataBaseA)
    }

    @Singleton
    @Provides
    fun provideDataBaseA(
        dataBaseAComponent: DataBaseAComponent
    ) : DataBaseA {
        return dataBaseAComponent.dataBaseA()
    }

    @Singleton
    @Provides
    fun provideDataBaseAComponent(): DataBaseAComponent {
        return DataBaseAComponent.factory().create(context)
    }
}
