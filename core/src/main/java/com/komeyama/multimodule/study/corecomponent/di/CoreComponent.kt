package com.komeyama.multimodule.study.corecomponent.di

import com.komeyama.multimodule.study.usecase_a.UseCaseA
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CoreModule::class]
)
interface CoreComponent {

    @Component.Builder
    interface Builder {
        fun build(): CoreComponent
        fun coreModule(coreModule: CoreModule): Builder // 引数ありのmoduleは引数で渡さないといけないため
    }

    fun useCaseA(): UseCaseA // FeatureAViewModelで必要なため
}