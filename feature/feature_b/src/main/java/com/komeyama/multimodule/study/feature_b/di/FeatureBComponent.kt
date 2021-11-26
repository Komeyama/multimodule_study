package com.komeyama.multimodule.study.feature_b.di

import androidx.lifecycle.ViewModelProvider
import com.komeyama.multimodule.study.corecomponent.di.CoreComponent
import com.komeyama.multimodule.study.corecomponent.di.ModuleScope
import com.komeyama.multimodule.study.corecomponent.di.ViewModelModule
import com.komeyama.multimodule.study.feature_b.FeatureBFragment
import dagger.Component

@ModuleScope
@Component(
    modules = [
        FeatureBModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
interface FeatureBComponent {

    @Component.Builder
    interface Builder {
        fun build(): FeatureBComponent
        fun coreComponent(coreComponent: CoreComponent): Builder
    }

    fun viewModelFactory(): ViewModelProvider.Factory

    fun inject(fragment: FeatureBFragment)
}