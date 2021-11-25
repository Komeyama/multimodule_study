package com.komeyama.multimodule.study.feature_a.di

import androidx.lifecycle.ViewModelProvider
import com.komeyama.multimodule.study.corecomponent.di.CoreComponent
import com.komeyama.multimodule.study.corecomponent.di.ModuleScope
import com.komeyama.multimodule.study.corecomponent.di.ViewModelModule
import com.komeyama.multimodule.study.feature_a.FeatureAFragment
import dagger.Component

@ModuleScope
@Component(
    modules = [
        FeatureAModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
interface FeatureAComponent {

    @Component.Builder
    interface Builder {
        fun build(): FeatureAComponent
        fun coreComponent(coreComponent: CoreComponent): Builder
    }

    fun viewModelFactory(): ViewModelProvider.Factory

    fun inject(activity: FeatureAFragment)
}