package com.komeyama.multimodule.study.di

import androidx.lifecycle.ViewModelProvider
import com.komeyama.multimodule.study.MainActivity
import com.komeyama.multimodule.study.corecomponent.di.CoreComponent
import com.komeyama.multimodule.study.corecomponent.di.ModuleScope
import com.komeyama.multimodule.study.corecomponent.di.ViewModelModule
import com.komeyama.multimodule.study.feature_a.FeatureAFragmentModule
import com.komeyama.multimodule.study.feature_b.FeatureBFragmentModule
import dagger.Component

@ModuleScope
@Component(
    modules = [
        AppModule::class,
        RouterModule::class,
        ViewModelModule::class,
        FeatureAFragmentModule::class,
        FeatureBFragmentModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun routerModule(routerModule: RouterModule): Builder
        fun coreComponent(coreComponent: CoreComponent): Builder // Component dependenciesのインスタンスは必ず渡す必要があるため
    }

    fun viewModelFactory(): ViewModelProvider.Factory

    fun fragmentFactory(): MainFragmentFactory

    fun inject(activity: MainActivity)
}