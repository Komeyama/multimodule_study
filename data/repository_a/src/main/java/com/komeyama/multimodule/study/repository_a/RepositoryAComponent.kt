package com.komeyama.multimodule.study.repository_a

import com.komeyama.multimodule.study.db_a.DataBaseA
import com.komeyama.multimodule.study.repository_a.internal.RepositoryAModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryAModule::class]
)
interface RepositoryAComponent {
    fun repositoryA(): RepositoryA

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance dataBaseA: DataBaseA
        ): RepositoryAComponent
    }

    companion object {
        fun factory(): Factory = DaggerRepositoryAComponent.factory()
    }
}