package com.komeyama.multimodule.study.di

import com.komeyama.multimodule.study.MainActivity
import com.komeyama.multimodule.study.corecomponent.di.CoreComponent
import com.komeyama.multimodule.study.corecomponent.di.ModuleScope
import com.komeyama.multimodule.study.corecomponent.di.ViewModelModule
import dagger.Component

@ModuleScope
@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun coreComponent(coreComponent: CoreComponent): Builder
    }

    fun inject(activity: MainActivity)
}