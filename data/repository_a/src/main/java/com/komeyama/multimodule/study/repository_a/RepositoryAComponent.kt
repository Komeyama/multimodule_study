package com.komeyama.multimodule.study.repository_a

import com.komeyama.multimodule.study.repository_a.internal.RepositoryAModule
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
        fun create(): RepositoryAComponent
    }

    companion object {
        fun factory(): Factory = DaggerRepositoryAComponent.factory()
    }
}