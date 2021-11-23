package com.komeyama.multimodule.study.usecase_a

import com.komeyama.multimodule.study.repository_a.RepositoryA
import com.komeyama.multimodule.study.usecase_a.internal.UseCaseAModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [UseCaseAModule::class]
)
interface UseCaseAComponent {
    fun useCaseA(): UseCaseA

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance repositoryA: RepositoryA
        ): UseCaseAComponent
    }

    companion object {
        fun factory(): Factory = DaggerUseCaseAComponent.factory()
    }
}