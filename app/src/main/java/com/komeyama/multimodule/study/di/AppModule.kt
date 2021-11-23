package com.komeyama.multimodule.study.di

import androidx.lifecycle.ViewModel
import com.komeyama.multimodule.study.MainViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}