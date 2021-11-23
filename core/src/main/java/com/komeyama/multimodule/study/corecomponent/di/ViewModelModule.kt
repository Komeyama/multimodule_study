package com.komeyama.multimodule.study.corecomponent.di

import androidx.lifecycle.ViewModelProvider
import com.komeyama.multimodule.study.corecomponent.utilies.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}